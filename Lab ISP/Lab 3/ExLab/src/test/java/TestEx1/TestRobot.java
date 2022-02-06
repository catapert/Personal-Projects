package TestEx1;

import Ex1.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRobot {
    @Test
    void TestConstructAndAddK(){
        Robot WallE = new Robot();
        assertEquals(1,WallE.getX());
        WallE.AddK(7);
        assertEquals(8,WallE.getX());
    }
}
