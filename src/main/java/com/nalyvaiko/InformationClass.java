package com.nalyvaiko;

import java.lang.reflect.*;
import java.util.Arrays;

public class InformationClass {

  private InformationClass() {
  }

  public static void getClassInfo(Object o) {
    System.out.println("Class info:");
    Class<?> clazz = o.getClass();
    System.out.println("Class simple name: " + clazz.getSimpleName()
        + "\nSuperclass: " + clazz.getSuperclass());

    System.out.println("\nClass constructors:");
    Constructor[] constructors = clazz.getDeclaredConstructors();
    for (Constructor constructor : constructors) {
      System.out.println("Name: " + constructor.getName()
          + ", parameter type: " + Arrays
          .toString(constructor.getParameterTypes()));
    }

    System.out.println("\nFields: ");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      System.out.println("Name: " + field.getName()
          + ", type: " + field.getType());
    }

    System.out.println("\nMethods:");
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println("Name: " + method.getName()
          + ", parameter type: " + Arrays.toString(method.getParameterTypes())
          + ", get return type: " + method.getReturnType());
    }
  }

}
