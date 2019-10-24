package ru.stqa.pft.sandbox;


public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alexei");
    hello("user");
    hello("bspb.qa");

    Square s = new Square(5);
    Rectangle r = new Rectangle(3, 2);

    System.out.println("Площадь квадрата со стороной " + s.l + " равна = " + s.area());
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("hello " + somebody + "!");
  }
}

