package theme_06_DefiningClasses.Exercises.P09_CatLady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, double earSize) {
        this.setName(name);
        this.earSize = earSize;
    }

    @Override
    public String toString () {
        return String.format("Siamese %s %.2f",this.getName(),this.earSize);
    }

    public double getEarSize() {
        return this.earSize;
    }

}
