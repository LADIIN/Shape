package com.epam.shape.parser;

import com.epam.shape.exception.TetrahedronException;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronDataParserTest {

    @Test
    public void testParseStringShouldParseStringToDoublesListWhenLineIsCorrect() throws TetrahedronException {
        //given
        TetrahedronDataParser tetrahedronDataParser = new TetrahedronDataParser();
        String line = "2.5 3 2.5 61.0 1 3 4 6 1.0 -4 1.0 -2.4";

        //when
        double[] actual = tetrahedronDataParser.parseStringToDouble(line);

        //then
        double[] expected = new double[]{2.5, 3, 2.5, 61, 1, 3, 4, 6, 1, -4, 1, -2.4};

        Assert.assertArrayEquals(expected, actual, 0.01);
    }

    //then
    @Test(expected = TetrahedronException.class)
    public void testParseStringShouldThrowExceptionWhenLineIsEmpty() throws TetrahedronException {
        //given
        TetrahedronDataParser tetrahedronDataParser = new TetrahedronDataParser();
        String line = "";

        //when
        double[] actual = tetrahedronDataParser.parseStringToDouble(line);
    }

    //then
    @Test(expected = TetrahedronException.class)
    public void testParseStringShouldThrowExceptionWhenStringIsNull() throws TetrahedronException{
        //given
        TetrahedronDataParser tetrahedronDataParser = new TetrahedronDataParser();
        String line = null;

        //when
        double[] actual = tetrahedronDataParser.parseStringToDouble(line);
    }

}
