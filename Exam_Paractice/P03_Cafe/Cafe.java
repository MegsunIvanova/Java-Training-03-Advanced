package Exam_Paractice.P03_Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(name).append(System.lineSeparator());
        sb.append(employees.stream().map(Employee::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }

}
