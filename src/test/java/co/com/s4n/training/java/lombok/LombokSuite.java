package co.com.s4n.training.java.lombok;

import co.com.s4n.training.java.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LombokSuite {

    @Test
    public void testLombokPerson(){
        Person person = new Person(23,"Andres","Ocampo","andresocampo@s4n.com");
        assertTrue(true);
        assertEquals(person.getEdad(),24);
    }
}
