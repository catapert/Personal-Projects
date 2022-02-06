package TestEx6;

import Pert.Catalin.Lab4.Ex6.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSquare {
    @Test
    void TestConstructor(){
        Square S1 = new Square();
        assertEquals(1, S1.getLength());
        assertEquals(1, S1.getWidth());
        Square S2 = new Square(4);
        assertEquals(4, S2.getLength());
        assertEquals(4, S2.getWidth());
        Square S3 = new Square(4,"navy blue",false);
        assertEquals(4, S3.getLength());
        assertEquals(4, S3.getWidth());
        assertEquals("navy blue", S3.getColor());
        assertEquals(false, S3.isFilled());
    }
    @Test
    void TestGetArea(){
        Square S = new Square(5);
        assertEquals(25,S.getArea());
    }
    @Test
    void TestGetPerimeter(){
        Square S = new Square(5);
        assertEquals(20,S.getPerimeter());
    }
}
