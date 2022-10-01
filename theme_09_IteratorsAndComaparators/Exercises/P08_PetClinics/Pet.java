package theme_09_IteratorsAndComaparators.Exercises.P08_PetClinics;

import java.util.Objects;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public boolean equals(Object otherPet) {
        if (this == otherPet) return true;
        if (!(otherPet instanceof Pet)) return false;
        Pet pet = (Pet) otherPet;
        return getAge() == pet.getAge() && getName().equals(pet.getName()) && getKind().equals(pet.getKind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getKind());
    }
}
