package com.major.springsource.code;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class EmployeeTest2 {
    public static void main(String[] args) throws Exception{
        Employee employee1 = new Employee("harry potter",3657,1993,07,01);
        Employee employee2 = new Employee("harry potter",3657,1993,07,01);
        Employee employee3 = new Employee("harry potter",3657,1993,07,01);
        Employee[] employees = new Employee[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        Employee[] result = (Employee[]) badCopyOf(employees,5);
        System.out.println(new ObjectAnalyzer().toString(result));
    }
    public static Object badCopyOf(Object[] a ,int newLength){
        if (!a.getClass().isArray()) return null;
        Object result = Array.newInstance(a.getClass().getComponentType(),newLength);
        System.arraycopy(a,0,result,0,Math.min(a.length,newLength));
        return result;
    }
}
