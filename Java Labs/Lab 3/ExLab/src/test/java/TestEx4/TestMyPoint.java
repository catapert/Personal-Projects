package TestEx4;

import Ex4.MyPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyPoint {
    @Test
    void TestsetXY(){
        MyPoint P1 = new MyPoint();
        assertEquals(1,P1.GetX());
        assertEquals(1,P1.GetY());
        P1.setXY(3,3);
        assertEquals(3,P1.GetX());
        assertEquals(3,P1.GetY());
    }
    @Test
    void TestDistanceToPoint(){
        MyPoint P1 = new MyPoint();
        assertEquals(1,P1.distance(1,2));
    }
    @Test
    void TestDistanceToObject(){
        MyPoint P1 = new MyPoint();
        MyPoint P2 = new MyPoint();
        P2.setXY(1,2);
        assertEquals(1,P1.distance(P2));
    }
}
