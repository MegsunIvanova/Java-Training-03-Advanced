package theme_06_DefiningClasses.Exercises.P07_Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Car:%n" +
                "%s %d", this.model, this.speed);
    }

}
