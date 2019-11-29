package com.nalyvaiko;

public class MyClass {

  @MyAnnotation
  private String name;
  @MyAnnotation(name = "Nalyvaiko")
  private String surName;
  private int i;

  private String returnName() {
    return name;
  }

  private int multiplyToTwo(int value) {
    return value * 2;
  }

  private double divide(int value1, int value2) {
    return (double) value1 / value2;
  }

  public String getSurName() {
    return surName;
  }

  public String getName() {
    return name;
  }

  public void myMethod(String a, int... args) {
    System.out.println("String parameter " + a);
    System.out.println("Int arguments:");
    for (int arg : args) {
      System.out.println(arg);
    }
  }

  public void myMethod(String... args) {
    System.out.println("String arguments:");
    for (String arg : args) {
      System.out.println(arg);
    }
  }
}
