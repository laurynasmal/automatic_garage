package lt.vilnius.laurynas.automatinis_garazas.services;

import lt.vilnius.laurynas.automatinis_garazas.beans.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static lt.vilnius.laurynas.automatinis_garazas.beans.Garage.maxCarWeight;

public class UserServices {
    static User[] allusers;
    static List<User> allusers1 = new ArrayList<>();

    static {
        initAllUsers1();
    }


    public static void checkEnteredWeight(int userListNumber) {
        if (allusers1.get(userListNumber).getCarWeight() <= 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Iveskite automobilio svori kilogramais");
            int weight = scanner.nextInt();
            allusers1.get(userListNumber).setCarWeight(weight);
            scanner.close();
        }
    }

    public static boolean checkIfCarWeigthGood(String id) {
        User tempVariable = getUserInfoByName(allusers1, id);
        if (tempVariable.getCarWeight() <= maxCarWeight) {
            return true;
        } else {
            return false;
        }
    }


    private static void initAllUsers1() {
        try {
            String tempTextCheck;
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Malina\\IdeaProjects\\AutomatinisGarazas\\UserData.txt"));
            while ((tempTextCheck = in.readLine()) != null) {
                allusers1.add(parseUser(tempTextCheck));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            //FIXME paleisti programa jei nera pradiniu duomenu
        }

    }

    private static User parseUser(String str) {
        String[] tmp = str.split(" ");
        User result = new User(tmp[0], tmp[1], tmp[2], Integer.valueOf(tmp[3]));
        return result;
    }

    public static void writeTextFile(String fileAddress) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(fileAddress));
        try {
            //create a temporary file

            out.flush();
            //int textLineCounter = 0;


            for (User tempUser: allusers1){
                    out.write(tempUser.getCodeUser() + " "
                            + tempUser.getPinUser() + " " + tempUser.getPayedTil() + " "
                            + tempUser.getCarWeight() + "\n");
                    //textLineCounter++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                out.close();
            } catch (Exception e) {
            }
        }
    }

    public static void payMonth(String userNR) {
        User tempVariable = getUserInfoByName(allusers1, userNR);
        try {
            Date d1 = OperationsWithDate.stringToDate(tempVariable.getPayedTil());
            Date now = new Date();
            if (d1.before(now)) {
                tempVariable.setPayedTil(OperationsWithDate.addOneMonth(now));
            } else {
                tempVariable.setPayedTil(OperationsWithDate.addOneMonth(d1));
            }
            System.out.println("Sumoketa iki: " + tempVariable.getPayedTil());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Papildyti nepavyko");
            int i = 0;
        }
    }

    public static void payDay(String userNR) {
        User tempVariable = getUserInfoByName(allusers1, userNR);
        try {
            Date d1 = OperationsWithDate.stringToDate(tempVariable.getPayedTil()); //is it logical?
            Date now = new Date();
            if (d1.before(now)) {
                tempVariable.setPayedTil(OperationsWithDate.addOneDay(now));
            } else {
                tempVariable.setPayedTil(OperationsWithDate.addOneDay(d1));
            }
            System.out.println("Sumoketa iki: " + tempVariable.getPayedTil());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Papildyti nepavyko");
            int i = 0;
        }
    }

    public static void payHour(String userNR) {
        User tempVariable = getUserInfoByName(allusers1, userNR);

        try {

            Date d1 = OperationsWithDate.stringToDate(tempVariable.getPayedTil());
            Date now = new Date();
            if (d1.before(now)) {
                tempVariable.setPayedTil(OperationsWithDate.addOneHour(now));
            } else {
                tempVariable.setPayedTil(OperationsWithDate.addOneHour(d1));
                }
            System.out.println("Sumoketa iki: " + tempVariable.getPayedTil());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Papildyti nepavyko");
            int i = 0;
        }
    }

    public static String endOfDate(int userNr) {
        return allusers1.get(userNr).getPayedTil();
    }

    public static boolean canCarGoIn(String id, String pin) {
        User tempVariable = getUserInfoByName(allusers1, id);
        return pin.equals(tempVariable.getPinUser());
    }

    public static void changeUserPin(String id, String oldpin, String newpin) {
        User tempVariable = getUserInfoByName(allusers1, id);
        if (tempVariable.getPinUser().equals(oldpin)) {
            tempVariable.setPinUser(newpin);
        } else {
            throw new RuntimeException("Ivesti neteisingi USER name arba PIN");
        }
    }

    private static User getUserInfoByName(List<User> allusers1, String userName) {
        for (User tempUser : allusers1) {
            if (userName.equals(tempUser.getCodeUser())) {
                return tempUser;
            }
        }
        return null;
    }

    public static void addNewUser(String userName, String pin, int weight){
        User result = new User(userName, pin, OperationsWithDate.returnActualTime() , weight);
        allusers1.add(result);
    }

//    public static boolean canYouEnterGarage(){
//        return OperationsWithDate.canYouEnter()
//    }

}
