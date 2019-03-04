package com.major.springsource.code;


import java.lang.reflect.*;
import java.util.Scanner;

public class RefelectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter class name:");
            name = scanner.next();
        }
        try {
            Class cls = Class.forName(name);
            Class supercls = cls.getSuperclass();
            String modifiers = Modifier.toString(cls.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (supercls != null && supercls != Object.class) System.out.print(" extends " + supercls.getName());
            System.out.print("\n{\n");
            printConstructors(cls);
            System.out.println();
            printMethods(cls);
            System.out.println();
            printFields(cls);
            System.out.println("}");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void printFields(Class cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields){
            Class type = field.getType();
            String name = field.getName();
            System.out.println("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName()+" "+name+";");
        }
     }

    private static void printMethods(Class cls) {
        Method[] methods= cls.getDeclaredMethods();
        for (Method method:methods){
            System.out.print("  ");
            Class returnType = method.getReturnType();
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(returnType.getName()+" "+method.getName()+" (");
            Class[] classes = method.getParameterTypes();
            for (int i = 0; i < classes.length; i++) {
                if (i>0) System.out.print(",");
                System.out.print(classes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printConstructors(Class cls) {
        Constructor[] constructors= cls.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.print("  ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(constructor.getName()+"(");
            Class[] classes = constructor.getParameterTypes();
            for (int i = 0; i < classes.length; i++) {
                if (i>0) System.out.print(",");
                System.out.print(classes[i].getName());
            }
            System.out.println(");");
        }
    }
}
