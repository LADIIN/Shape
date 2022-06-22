package com.epam.shape.creator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TetrahedronCreatorTest {

    //TODO: check hot avoid get() problems.

    @Test
    public void testCreateTetrahedronShouldCreateTetrahedronWhenDataIsCorrect() throws TetrahedronException {
        //given
        double[] coordinates = new double[]{2.5, 3, 2.5, 61.0, 1, 3, 4, 6, 1.0, -4, 1.0, -2.4};
        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();

        //when
        Optional<Tetrahedron> actual = tetrahedronCreator.createTetrahedron(coordinates);

        //then
        Tetrahedron expected = new Tetrahedron(new Point(2.5, 3, 2.5), new Point(61.0, 1, 3),
                new Point(4, 6, 1.0), new Point(-4, 1.0, -2.4));

        Assert.assertEquals(expected, actual.get());
    }

    @Test
    public void testCreateTetrahedronShouldReturnNullWhenTetrahedronIsNotPossible() throws TetrahedronException {
        //given
        double[] coordinates = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();

        //when
        Optional<Tetrahedron> actual = tetrahedronCreator.createTetrahedron(coordinates);

        //then
        Assert.assertFalse(actual.isPresent());

    }

    //then
    @Test(expected = TetrahedronException.class)
    public void testCreateTetrahedronShouldThrowExceptionWhenWrongAmountOfCoordinates() throws TetrahedronException {
        //given
        double[] coordinates = new double[]{2.5, 3, 2.5, 61.0, 1, 3, 4, 6, 1.0, -4, 1.0, -2.4, 2.3, 4.5, 23};
        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();

        //when
        Optional<Tetrahedron> actual = tetrahedronCreator.createTetrahedron(coordinates);
    }

    //then
    @Test(expected = TetrahedronException.class)
    public void testCreateTetrahedronShouldThrowExceptionWhenArrayIsNull() throws TetrahedronException {
        //given
        double[] coordinates = null;
        TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();

        //when
        Optional<Tetrahedron> actual = tetrahedronCreator.createTetrahedron(coordinates);

    }
}
