package ru.stqa.pft.sandbox;


public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alexei");
    hello("user");
    hello("bspb.qa");

    Square s = new Square(5);
    Rectangle r = new Rectangle(3, 2);
    Point p1 = new Point(2,-1);
    Point p2 = new Point(-3,0);


    System.out.println("Площадь квадрата со стороной " + s.l + " равна = " + s.area());
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна = " + r.area());
    System.out.println("Расстояние между двумя точками " + "["+p2.x+";"+p2.y+"]" + " и " + "["+p1.x+";"+p1.y+"]" + " равно = " + CalcDistance(p2,p1));
    System.out.println("Расстояние между двумя точками " + "["+p2.x+";"+p2.y+"]" + " и " + "["+p1.x+";"+p1.y+"]" + " равно = " + p2.CalcDistanceBetweenTwoPoints(p2,p1));
  }
    public  static double CalcDistance(Point p1, Point p2){
        return Math.sqrt((Math.pow((p2.x-p1.x),2)) + Math.pow((p2.y-p1.y),2));
    }


    public static void hello(String somebody) {
    System.out.println("hello " + somebody + "!");
  }

}

