package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(2,-1);
    Point p2 = new Point(-3,0);
    Point p3 = new Point(0,0);
    Point p4 = new Point(1,1);
    Assert.assertEquals(p2.CalcDistanceBetweenTwoPoints(p2,p1),5.0990195135927845);
    Assert.assertEquals(p2.CalcDistanceBetweenTwoPoints(p3,p4),1.4142135623730951);

  }
}
