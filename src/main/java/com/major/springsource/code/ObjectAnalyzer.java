package com.major.springsource.code;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer{
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object object) throws Exception{
        if (object == null) return "null";
        if (visited.contains(object)) return "...";
        visited.add(object);
        Class cls = object.getClass();
        if (cls == String.class) return (String) object;
        if (cls.isArray()) {
            String r = cls.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(object, i);
                if (cls.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }
        String r = cls.getName();
        do {
            r += "[";
            Field[] fields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += field.getName() + "=";
                    Class t = field.getType();
                    Object val = field.get(object);
                    if (t.isPrimitive()) r += val;
                    else r += toString(val);

                }
            }
            r+="]";
            cls=cls.getSuperclass();
        }
        while (cls!=null);
        return r;
    }
}
