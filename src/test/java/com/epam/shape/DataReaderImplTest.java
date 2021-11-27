package com.epam.shape;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.DataReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderImplTest {
    @Test
    public void testAddShouldReturnStringWhenPathIsCorrect() throws TetrahedronException {
        //given
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("2.5 3 2.5 61.0 1 3 4 6 1.0 -4 1.0 -2.4");

        String path = "src/main/java/resources/data.txt";
        DataReaderImpl dataReader = new DataReaderImpl();

        //when
        List<String> result = dataReader.read(path);

        //then
        Assert.assertEquals(expectedResult, result);

    }

}
