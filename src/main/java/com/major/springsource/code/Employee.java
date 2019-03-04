package com.major.springsource.code;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalay(int percent) {
        this.salary = this.salary * (100 + percent) / 100;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                ", salary=" + String.format("%.2f", salary) +
                ", hireDay=" + hireDay +
                '}';
    }

    @Override
    public void finalize() {

    }
}