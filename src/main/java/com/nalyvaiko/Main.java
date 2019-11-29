package com.nalyvaiko;

import java.lang.reflect.*;

public class Main {

  public static void main(String[] args) {
    MyClass myClass = new MyClass();
    printFieldsAnnotateByAnnotationAndItsValue(myClass);
    invokeThreeMethods(myClass);
    invokeMyMethods(myClass);
    InformationClass.getClassInfo(new MyClass());
  }

  private static void printFieldsAnnotateByAnnotationAndItsValue(
      MyClass myClass) {
    Class clazz = myClass.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(MyAnnotation.class)) {
        System.out.println("Field name: " + field.getName());
        System.out.println(
            "Annotation value: " + field.getAnnotation(MyAnnotation.class)
                .name() + "\n");
      }
    }
    System.out.println();
  }

  private static void invokeThreeMethods(MyClass myClass) {
    Class clazz = myClass.getClass();
    try {
      System.out.print("Invoke multiplyToTwo method,return value ");
      Method method = clazz.getDeclaredMethod("multiplyToTwo", int.class);
      method.setAccessible(true);
      System.out.println(method.invoke(myClass, 2));
      System.out.print("Invoke returnName method,return value ");
      method = clazz.getDeclaredMethod("returnName");
      method.setAccessible(true);
      System.out.println(method.invoke(myClass));
      System.out.print("Invoke divide method,return value ");
      method = clazz.getDeclaredMethod("divide", int.class, int.class);
      method.setAccessible(true);
      System.out.println(method.invoke(myClass, 3, 2));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println();
  }

  private static void invokeMyMethods(MyClass myClass) {
    Class clazz = myClass.getClass();
    String[] stringArray = new String[]{"Orest", "Nalyvaiko"};
    String string = "Integer values";
    int[] ints = new int[]{1, 2, 3};
    try {
      Method method = clazz.getDeclaredMethod("myMethod", String[].class);
      method.invoke(myClass, (Object) stringArray);
      method = clazz.getDeclaredMethod("myMethod", String.class, int[].class);
      method.invoke(myClass, string, ints);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println();
  }
}
