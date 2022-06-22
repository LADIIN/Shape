package com.epam.shape.reader;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.impl.DataReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
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

    @Test(expected = TetrahedronException.class)
    public void testAddShouldThrowExceptionWhenFileDoesNotExist() throws TetrahedronException {
        //given
        String path = "src/main/java/resources/NonExistentFile.txt";
        DataReaderImpl dataReader = new DataReaderImpl();

        //when
        List<String> result = dataReader.read(path);

    }

    @Test(expected = TetrahedronException.class)
    public void testAddShouldThrowExceptionWhenPathIsNull() throws TetrahedronException {
        //given
        String path = null;
        DataReaderImpl dataReader = new DataReaderImpl();

        //when
        List<String> result = dataReader.read(path);

    }

    @Test(expected = TetrahedronException.class)
    public void testAddShouldThrowExceptionWhenPathIsEmpty() throws TetrahedronException {
        //given
        String path = "";
        DataReaderImpl dataReader = new DataReaderImpl();

        //when
        List<String> result = dataReader.read(path);

    }
}
