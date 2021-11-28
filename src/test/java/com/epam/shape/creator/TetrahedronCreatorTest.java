package com.epam.shape.creator;

import com.epam.shape.creator.impl.TetrahedronCreatorImpl;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronCreatorTest {

    @Test
    public void testAddShouldCreateTetrahedronWhenDataIsCorrect() throws TetrahedronException {
        //given
        double[] coordinates = new double[]{2.5, 3, 2.5, 61.0, 1, 3, 4, 6, 1.0, -4, 1.0, -2.4};
        TetrahedronCreatorImpl tetrahedronCreator = new TetrahedronCreatorImpl();

        //when
        Tetrahedron actual = tetrahedronCreator.createTetrahedron(coordinates);

        //then
        Tetrahedron expected = new Tetrahedron(new Point(2.5, 3, 2.5), new Point(61.0, 1, 3),
                new Point(4, 6, 1.0), new Point(-4, 1.0, -2.4));

        Assert.assertEquals(expected, actual);


    }
}
