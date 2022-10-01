package theme_09_IteratorsAndComaparators.Exercises.P07_EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherPerson) {
        if (this == otherPerson) return true;
        if (!(otherPerson instanceof Person)) return false;
        Person person = (Person) otherPerson;
        return getAge() == person.getAge() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public int compareTo(Person otherPerson) {
        int result = this.getName().compareTo(otherPerson.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return result;
    }
}
