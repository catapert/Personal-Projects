package Ex1;

import Pert.Catalin.Lab5.Ex1.Circle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircle {
    @Test
    void TestConstructor(){
        Circle C1 = new Circle();
        assertEquals(1.0, C1.getRadius());
        Circle C2 = new Circle(3,"Navy blue",true);
        assertEquals(3,C2.getRadius());
        assertEquals("Navy blue",C2.getColor());
        assertEquals(true,C2.isFilled());
    }
    @Test
    void TestGetArea(){
        Circle C = new Circle(3,"Navy blue",false);
        assertEquals(3*3*Math.PI, C.getArea());
    }
    @Test
    void TestPerimeter(){
        Circle C = new Circle(3,"Navy blue",false);
        assertEquals(2*3*Math.PI,C.getPerimeter());
    }
}
