package Exam_Paractice.P03_Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(name).append(" are:").append(System.lineSeparator());
        sb.append(roster.stream()
                .map(Person::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }
}
