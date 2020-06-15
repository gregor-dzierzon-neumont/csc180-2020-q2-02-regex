import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullName() {

        //arrange
        Person person = new Person("John","Doe");
        String expectedResult = "John Doe";

        //act
        String actualResult = person.getFullName();

        //assert
        assertEquals(expectedResult, actualResult);

    }
}