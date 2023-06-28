package com.practice.stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, 3000),
                new Employee("Jane", 35, 5000),
                new Employee("Bob", 40, 7000),
                new Employee("Alice", 45, 9000),
                new Employee("Tom", 50, 12000),
                new Employee("Saurabh",26,35000),
                new Employee("Abhishek",26,42000)
        );

        double averageSalary = employees.stream()
                .filter(e -> e.getAge() > 25)   // filter employees older than 30
                .mapToDouble(Employee::getSalary)  // get the salary of each employee
                .average()   // calculate the average salary
                .orElse(0);  // if there are no employees older than 30, return 0

        System.out.println("Average salary of employees older than 30: " + averageSalary);
    }
}
