package TestEx1;

import Pert.Catalin.Lab4.Ex1.Circle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircle {
    @Test
    void TestConstruct(){
        Circle C = new Circle();
        assertEquals(1.0, C.getRadius());
        assertEquals("red",C.getColor());
        assertEquals(3.141592653589793,C.getArea());
        Circle C2 = new Circle(2);
        assertEquals(2.0, C2.getRadius());
        assertEquals(12.566370614359172,C2.getArea());

    }

}
