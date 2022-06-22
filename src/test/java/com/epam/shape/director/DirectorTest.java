package com.epam.shape.director;

import com.epam.shape.creator.TetrahedronCreator;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.parser.TetrahedronDataParser;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.TetrahedronLineValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class DirectorTest {
    private static final String LINE = "2.5 3 2.5 61.0 1 3 4 6 1.0 -4 1.0 -2.4";
    private static final double[] COORDINATES = new double[]{2.5, 3, 2.5, 61.0, 1, 3, 4, 6, 1.0, -4, 1.0, -2.4};
    private static final Tetrahedron TETRAHEDRON = Mockito.mock(Tetrahedron.class);
    private static final String PATH = "path";

    @Test
    public void testCreateShouldCreateWhenValidData() throws TetrahedronException {
        //given
        DataReaderImpl reader = Mockito.mock(DataReaderImpl.class);
        Mockito.when(reader.read(PATH)).thenReturn(Arrays.asList(LINE));

        TetrahedronLineValidator lineValidator = Mockito.mock(TetrahedronLineValidator.class);
        Mockito.when(lineValidator.isValid(Mockito.anyString())).thenReturn(true);

        TetrahedronDataParser parser = Mockito.mock(TetrahedronDataParser.class);
        Mockito.when(parser.parseStringToDouble(Mockito.anyString())).thenReturn(COORDINATES);

        TetrahedronCreator creator = Mockito.mock(TetrahedronCreator.class);
        Mockito.when(creator.createTetrahedron(Mockito.any(double[].class))).thenReturn(Optional.of(TETRAHEDRON));

        Director director = new Director(reader, creator, parser, lineValidator);

        //when
        List<Tetrahedron> tetrahedrons = director.createTetrahedrons(PATH);

        //then
        Assert.assertEquals(1, tetrahedrons.size());
        Assert.assertEquals(tetrahedrons.get(0), TETRAHEDRON);

    }

}
