package com.major.springsource.code;

import java.util.Random;

public class EmployeeTest {
    public static void main(String[] args, Class aClass1) {
        Employee employee= new Employee("zhangzixuan", 35.2d, 2003, 3, 2);
        //对象getclass
        Class employeeClass = employee.getClass();
        System.out.println(employeeClass.getName());
        //Class.forname静态方法，通过类名字符串
        Class aClass = aClass1;
        try {
            aClass = Class.forName("java.util.Random");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Random random = null;
        try {
            random = (Random) aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(random.nextInt());
        //类.class
        System.out.println(int.class.getName());
        System.out.println(Double[].class.getName());
        System.out.println(employee.getClass()==Employee.class);
    }
}


