package Ex1;

import Pert.Catalin.Lab5.Ex1.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRectangle {
    @Test
    void TestConstruct(){
        Rectangle R1 = new Rectangle();
        assertEquals(1.0, R1.getWidth());
        assertEquals(1.0, R1.getLength());
        Rectangle R2 = new Rectangle(2,3);
        assertEquals(2, R2.getWidth());
        assertEquals(3, R2.getLength());
        Rectangle R3 = new Rectangle(2,3,"Navy Blue",false);
        assertEquals(2, R3.getWidth());
        assertEquals(3, R3.getLength());
        assertEquals("Navy Blue",R3.getColor());
        assertEquals(false,R3.isFilled());
    }
    @Test
    void TestGetArea(){
        Rectangle R = new Rectangle(2,3);
        assertEquals(6,R.getArea());
    }
    @Test
    void TestGetPerimeter(){
        Rectangle R = new Rectangle(2,3);
        assertEquals(10,R.getPerimeter());
    }
}