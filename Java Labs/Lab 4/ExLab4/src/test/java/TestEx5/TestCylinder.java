package TestEx5;

import Pert.Catalin.Lab4.Ex5.Cylinder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCylinder {
    @Test
    void TestConstruct(){
        Cylinder Cy1 = new Cylinder();
        assertEquals(1.0, Cy1.getHeight());
        Cylinder Cy2= new Cylinder(4);
        assertEquals(4,Cy2.getRadius());
        Cylinder Cy3= new Cylinder(4,2);
        assertEquals(4,Cy3.getRadius());
        assertEquals(2, Cy3.getHeight());
    }
    @Test
    void TestGetVolume(){
        Cylinder Cy = new Cylinder(3,2);
        assertEquals(Math.PI*3*3*2,Cy.getVolume() );
    }
}
