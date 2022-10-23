package Exam_Paractice.P03_Openning_vEP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
//        return employees.removeIf(e -> e.getName().equals(name));
        Employee employeeToRemove = getEmployee(name);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        } else {
            return false;
        }
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(name).append(":").append(System.lineSeparator());
        sb.append(employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator())));
        return sb.toString();
    }

}
