package edu.neumont.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegExParserTest {

    @BeforeEach
    public void setup(){

    }

    @Test
    void should_parse_first_last_name_from_csv_line() {

        //arrange
        String line = "Carmita Mostyn,837-16-2803,cmostynd4@nydailynews.com,588-901-8764";
        String expected = "Carmita Mostyn";

        //act
        String actual = RegExParser.parseName(line);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void should_parse_first_middle_last_name_from_csv_line() {

        //arrange
        String line = "Carmita A Mostyn,837-16-2803,cmostynd4@nydailynews.com,588-901-8764";
        String expected = "Carmita A Mostyn";

        //act
        String actual = RegExParser.parseName(line);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void should_not_parse_invalid_name_from_csv_line() {

        //arrange
        String line = "Carmita,837-16-2803,cmostynd4@nydailynews.com,588-901-8764";

        //act
        String actual = RegExParser.parseName(line);

        //assert
        assertNull(actual);
    }


    @Test
    void should_parse_valid_phone() {

        //arrange
        String line = "Carmita,837-16-2803,cmostynd4@nydailynews.com,588-901-8764";
        String expected = "588-901-8764";

        //act
        String actual = RegExParser.parsePhone(line);

        //assert
        assertEquals(expected, actual);
    }


    @Test
    void pattern_should_parse_phone() {

        //arrange
        String line = "Carmita,837-16-2803,cmostynd4@nydailynews.com,588-901-8764";
        String pattern = "((\\d{3}-){2}\\d{4})";
        String expected = "588-901-8764";

        //act
        String actual = RegExParser.parse(line,pattern);

        //assert
        assertEquals(expected, actual);
    }

}