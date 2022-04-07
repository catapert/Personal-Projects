package TestEx2;

import Pert.Catalin.Lab4.Ex2.Author;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthor {
    @Test
    void TestCreateAuthor() {
        Author First = new Author("Joe", "Joe@hotmail.com", 'M');
        assertEquals("Joe", First.getName());
        assertEquals('M', First.getGender());
        assertEquals("Joe@hotmail.com", First.getEmail());
    }


}
