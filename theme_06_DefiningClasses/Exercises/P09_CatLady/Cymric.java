package theme_06_DefiningClasses.Exercises.P09_CatLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        this.setName(name);
        this.furLength = furLength;
    }

    @Override
    public String toString () {
        return String.format("Cymric %s %.2f",this.getName(),this.furLength);
    }

    public double getFurLength () {
        return this.furLength;
    }

}



