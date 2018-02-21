package lt.vilnius.laurynas.automatinis_garazas;

import lt.vilnius.laurynas.automatinis_garazas.services.UserServices;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static final String fileAddress = "C:\\Users\\Malina\\IdeaProjects\\AutomatinisGarazas\\UserData.txt";
    // User[] initatedusers = UserServices.allusers;


    public static void main(String[] args) {
        //UserServices.initAllUsers();


        mainMenu();

        scanner.close();

    }


    private static void mainMenu() {
        boolean status = true;
        while (status == true) {
            printMainMenu();
            System.out.println("Pasirinkite tinkama varianta");
            int input = -1;
            try {
                input = inputAndTest();
            } catch (Exception h) {
                System.out.println("Iveskite viena skaiciu\n\n");
                continue;
            }
            if (input == 0) {
                try {
                    UserServices.writeTextFile(fileAddress);
                    status = false;
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("Issaugoti nepavyko");
                    break;
                }
//                status = false;
//                break;
            }
            if (input > 3) {
                continue;
            }
            switch (input) {
                case 1:
                    System.out.println("Iveskite ID");
                    String idtemp = scanner.next();

                    try {
                        //int correctUser = UserServices.findCarIdByUser(idtemp);
                        System.out.println("Iveskite PIN");
                        String pintemp = scanner.next();
                        //int correctPin = UserServices.findCarIdByPin(pintemp);
                        //UserServices.checkEnteredWeight(correctUser);
                        //if (correctPin == correctUser && UserServices.checkIfCarWeigthGood(correctUser)) {
                        if (UserServices.canCarGoIn(idtemp, pintemp) && UserServices.checkIfCarWeigthGood(idtemp)) {
                            System.out.println("Galite ivaziuoti");
                            break;
                        } else {
                            System.out.println("Iveskite tinkama ID arba Pin");
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Iveskite tinkama ID arba Pin");
                        break;
                    }
                case 2:
                    System.out.println("Iveskite ID");
                    String idCheck = scanner.next();
                    System.out.println("Iveskite sena PIN");
                    String pinCheck = scanner.next();
                    System.out.println("Iveskite nauja PIN");
                    String pinNew = scanner.next();
                    try {
                        UserServices.changeUserPin(idCheck, pinCheck, pinNew);
                        System.out.println("Vartojojo "+idCheck+" PIN yra sekmingai pakeistas");
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                case 3:
                    System.out.println("Iveskite ID");
                    String lastidCheck = scanner.next();
                    payMenu();
                    try {
                        int n = inputAndTest();
                        switch (n) {
                            case 1:
                                UserServices.payHour(lastidCheck);
                                break;
                            case 2:
                                UserServices.payDay(lastidCheck);
                                break;
                            case 3:
                                UserServices.payMonth(lastidCheck);
                                break;

                            default:
                                System.out.println("Ivestas negalimas variantas");
                        }
                    } catch (Exception ez) {
                        ez.printStackTrace();
                        System.out.println("Papildyti nepavyko");
                        break;
                    }


            }


        }


    }

    private static int inputAndTest() {
        String testIfInt = scanner.next();
        int x = Integer.parseInt(testIfInt);
        return x;
    }

    private static void printMainMenu() {
        System.out.println("Sveiki atvyke i garaza");
        System.out.println("Iveskite savo pasirinkima");
        System.out.print("1. Noredami ivaziuoti iveskite savo ID ir PIN\n" +
                "2. Pasikeiskite savo PIN\n" +
                "3. Apmokekite\n" +
                "0. Uzdarykite programa\n");
    }

    private static void payMenu() {
        System.out.println("Pasirinkite norima mokejimo varianta:\n" +
                "1. Moketi valanda i prieki\n" +
                "2. Moketi diena i prieki\n" +
                "3. Moketi menesi i prieki\n" +
                "Iveskite savo pasirinkima:\n");
    }
}
