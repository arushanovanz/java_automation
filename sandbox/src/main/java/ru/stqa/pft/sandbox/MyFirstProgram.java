package ru.stqa.pft.sandbox;


public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alexei");
    hello("user");
    hello("bspb.qa");

    double len = 5;
    double a = 5;
    double b = 4;

    System.out.println("Площадь квадрата со стороной " + len + " равна = " + area(len));
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна = " + area(a, b));
  }


  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }

  public static void hello(String somebody) {
    System.out.println("hello " + somebody + "!");
  }
}

