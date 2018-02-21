package lt.vilnius.laurynas.automatinis_garazas.services;

import lt.vilnius.laurynas.automatinis_garazas.beans.*;

import java.io.*;

public class TextInputNOTUSED {

    private String[] savedUserList = new String[Garage.maxParkingSlot];

    //static User[] allusers;
    //private String address = "C:\Users\Malina\IdeaProjects\AutomatinisGarazas\text.txt";
    //FileInputStream file = new FileInputStream("C:\\Users\\Malina\\IdeaProjects\\AutomatinisGarazas\\UserData.txt");
    public void readTextFile() throws IOException {
        String tempTextCheck;
        int counterLogsUser = 0;
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Malina\\IdeaProjects\\AutomatinisGarazas\\UserData.txt"));
        while ((tempTextCheck = in.readLine()) != null) {
            savedUserList[counterLogsUser] = tempTextCheck;
            counterLogsUser++;
        }
        in.close();
    }

    public String[] getSavedUserList() {
        return savedUserList;
    }

    public void writeTextFile() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Malina\\IdeaProjects\\AutomatinisGarazas\\UserData.txt"));
        out.flush();
        int textLineCounter = 0;
        while (textLineCounter < Garage.maxParkingSlot) {
            System.out.println(UserServices.allusers[textLineCounter].getCodeUser() + " "
                    + UserServices.allusers[textLineCounter].getPinUser() + " "
                    + UserServices.allusers[textLineCounter].getCarWeight() + " " +
                    UserServices.allusers[textLineCounter].getPayedTil());
            textLineCounter++;
        }
        out.close();
    }
}
