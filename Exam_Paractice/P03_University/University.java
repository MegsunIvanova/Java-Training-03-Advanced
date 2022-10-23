package Exam_Paractice.P03_University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() >= capacity) {
            return "No seats in the university";
        }

        Student search = students.stream().filter(s -> s.getFirstName().equals(student.getFirstName())
                && s.getLastName().equals(student.getLastName())).findFirst().orElse(null);

        if (search != null) {
            return "Student is already in the university";
        }

        students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(s -> s.getFirstName().equals(firstName)
                && s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        return students.stream()
                .map(s -> String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
