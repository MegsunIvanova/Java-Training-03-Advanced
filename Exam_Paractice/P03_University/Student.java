package Exam_Paractice.P03_University;

import java.util.Objects;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", firstName, lastName, bestSubject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getFirstName().equals(student.getFirstName()) && getLastName().equals(student.getLastName()) && getBestSubject().equals(student.getBestSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getBestSubject());
    }
}
