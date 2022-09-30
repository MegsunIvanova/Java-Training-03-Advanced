package theme_06_DefiningClasses.Exercises.P09_CatLady;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.setName(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", this.getName(), this.decibelsOfMeows);
    }

    public double getDecibelsOfMeows() {
        return this.decibelsOfMeows;
    }
}
