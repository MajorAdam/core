package com.major.springsource.code;

import java.util.*;
import java.util.function.UnaryOperator;

public class GenericTest {
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTITY_FN;
    }
    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        add(strings,"123");
//        System.out.println(strings.get(0));
//        Set<String> a = new HashSet();
//        a.add("dasdf");
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));
        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
        Collections.reverseOrder();
    }

    private static <T extends String> void add(List<T> a, T value) {
        a.add(value);
    }
    public static <E extends Comparable<E>> E max(Collection<E> collection){
        E result = null;
        for (E e:collection){
            if(e==null||e.compareTo(e)>0){
                result = e;
            }
        }
        return result;
    }
}
