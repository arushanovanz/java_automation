package ru.stqa.pft.sandbox;

public class Point {
  public int x;
  public int y;

  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
  public double getX (){
    return x;
  }
  public double getY (){
    return y;
  }

  public  double CalcDistanceBetweenTwoPoints(Point p2, Point p1) {
    return Math.sqrt((Math.pow((p2.getX()-p1.getX()),2)) + Math.pow((p2.getY()-p1.getY()),2));
  }



}
