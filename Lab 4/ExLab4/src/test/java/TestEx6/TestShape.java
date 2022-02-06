package TestEx6;

import Pert.Catalin.Lab4.Ex6.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShape {
    @Test
    void TestConstructor(){
        Shape s1 = new Shape();
        assertEquals("red",s1.getColor());
        assertEquals(true,s1.isFilled());
        Shape s2 = new Shape("purple",false);
        assertEquals("purple",s2.getColor());
        assertEquals(false,s2.isFilled());
    }
}
