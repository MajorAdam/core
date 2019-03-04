package com.major.springsource.code;

public class Manager extends Employee {
    private double bonus;
    public Manager(String name, double salary, int year, int month, int day,double bonus) {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary(){
        return super.getSalary()+this.bonus;
    }

    public static void main(String[] args) {
        Manager[] managers = new Manager[3];
        Employee[] employees = managers;
        employees[0] = new Manager("3434",8374,234,10,3,0);
    }
}
