package TestEx3;

import Pert.Catalin.Lab4.Ex2.Author;
import Pert.Catalin.Lab4.Ex3.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBook {
    @Test
    void TestConstructWithoutQty(){
        Author firstA = new Author("George R. R. Martin","G@hotmail.com",'M');
        Book firstB =new Book("GoT",firstA ,45);
        assertEquals("GoT",firstB.getName());
        assertEquals(45,firstB.getPrice());
    }
    @Test
    void TestConstructWithQty(){
        Author firstA = new Author("George R. R. Martin","G@hotmail.com",'M');
        Book firstB =new Book("GoT",firstA ,45.2,100);
        assertEquals("GoT",firstB.getName());
        assertEquals(45.2,firstB.getPrice());
        assertEquals(100, firstB.getQtyInStock());
    }
}
