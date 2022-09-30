package theme_06_DefiningClasses.Exercises.P08_FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private String birthdate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String text) {
        String regexName = "[A-Z][a-z]+ [A-Z][a-z]+";
        String regexBirthday = "[\\d]{1,2}\\/[\\d]{1,2}\\/[\\d]{4}";
        if (text.matches(regexName)) {
            this.name = text;
        } else if (text.matches(regexBirthday)) {
            this.birthdate = text;
        }
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public String getParentsAsSting() {
        if (parents.size() > 0) {
            return String.format("Parents:\n%s",
                    parents.stream()
                            .map(parent -> parent.getName() + " " + parent.getBirthdate())
                            .collect(Collectors.joining(System.lineSeparator())));
        }
        return "Parents:";
    }

    public String getChildrenAsSting() {
        if (children.size() > 0) {
            return String.format("Children:\n%s",
                    children.stream()
                            .map(child -> child.getName() + " " + child.getBirthdate())
                            .collect(Collectors.joining(System.lineSeparator())));
        }
        return "Children:";
    }

    @Override
    public String toString() {
        return String.format("%s %s\n" +
                "%s%n" +
                "%s", this.name, this.birthdate, this.getParentsAsSting(), this.getChildrenAsSting());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }


}
