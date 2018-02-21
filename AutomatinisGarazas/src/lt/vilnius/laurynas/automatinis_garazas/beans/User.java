package lt.vilnius.laurynas.automatinis_garazas.beans;

public class User {
    private String codeUser;
    private String pinUser;
    private String payedTil;
    private int carWeight;

    public User(String codeUser, String pinUser, String payedTil, int carWeight) {
        this.codeUser = codeUser;
        this.pinUser = pinUser;
        this.payedTil = payedTil;
        this.carWeight = carWeight;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public String getPinUser() {
        return pinUser;
    }

    public String getPayedTil() {
        return payedTil;
    }

    public int getCarWeight() {
        return carWeight;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public void setPinUser(String pinUser) {
        this.pinUser = pinUser;
    }

    public void setPayedTil(String payedTil) {
        this.payedTil = payedTil;
    }

    public void setCarWeight(int carWeight) {
        this.carWeight = carWeight;
    }
}
