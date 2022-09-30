package theme_06_DefiningClasses.Exercises.P03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public void drive(int amountOfKm) {
        double fuelNeeded = amountOfKm * fuelCostFor1km;
        if (fuelNeeded <= this.fuelAmount) {
            distanceTraveled += amountOfKm;
            fuelAmount -= fuelNeeded;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
