package lt.vilnius.laurynas.automatinis_garazas.beans;

public class Garage {
    public static final int maxParkingSlot = 60;
    public static final int maxCarWeight = 3000;
    private int carInsideCount;

    public Garage(int carInsideCount) {
        this.carInsideCount = carInsideCount;
    }

    public int getCarInsideCount() {
        return carInsideCount;
    }

    public void setCarInsideCount(int carInsideCount) {
        this.carInsideCount = carInsideCount;
    }
}
