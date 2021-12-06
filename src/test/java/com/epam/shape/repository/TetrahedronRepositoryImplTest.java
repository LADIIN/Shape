package com.epam.shape.repository;

import com.epam.shape.entity.Point;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.observer.impl.TetrahedronStore;
import com.epam.shape.repository.impl.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TetrahedronRepositoryImplTest {
    private static final Integer Id = 3;

    private final static TetrahedronIdentifiable FIRST = new TetrahedronIdentifiable(
            1,
            new Point(0.577, 0, 1.634),
            new Point(0, -1, 0),
            new Point(1.732, 0, 0),
            new Point(0, 1, 0));

    private final static TetrahedronIdentifiable SECOND = new TetrahedronIdentifiable(
            2,
            new Point(-2, 1, 2),
            new Point(-2, 9, 2),
            new Point(-2, 5, 8.928),
            new Point(4.532, 5, 4.31));

    private final static TetrahedronIdentifiable THIRD = new TetrahedronIdentifiable(
            3,
            new Point(1, 2, -2),
            new Point(9, 2, -2),
            new Point(5, 8.93, -2),
            new Point(5, 4.31, 4.532));

    private final static TetrahedronIdentifiable FOURTH = new TetrahedronIdentifiable(
            4,
            new Point(2.82, 1.66, 0),
            new Point(-2.15, 0.41, 0),
            new Point(0.7, -0.4, 4.19),
            new Point(1.42, -3.27, 0)
    );

    private final static TetrahedronIdentifiable FIFTH = new TetrahedronIdentifiable(
            5,
            new Point(-2.83, 0.96, 0),
            new Point(1.42, -3.27, 0),
            new Point(1.3, 1.57, 0),
            new Point(-0.04, -0.89, 3.95)
    );

    private final static TetrahedronIdentifiable SIXTH = new TetrahedronIdentifiable(
            6,
            new Point(0.36, 1.25, 0),
            new Point(2.18, 0.83, 0),
            new Point(1.64, 2.62, 0),
            new Point(1.4, 1.57, 1.53)
    );


    @Test
    public void testQueryShouldReturnListWhenThereIsSuchId() throws TetrahedronException {
        //given
        IdSpecification idSpecification = new IdSpecification(Id);

        TetrahedronRepositoryImpl repository = new TetrahedronRepositoryImpl();
        repository.addTetrahedron(FIRST);
        repository.addTetrahedron(SECOND);
        repository.addTetrahedron(THIRD);
        repository.addTetrahedron(FOURTH);
        repository.addTetrahedron(FIFTH);
        repository.addTetrahedron(SIXTH);

        //when
        List<TetrahedronIdentifiable> actual = repository.query(idSpecification);

        //then
        TetrahedronIdentifiable expected = THIRD;
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals(THIRD, actual.get(0));

    }

    @Test
    public void testQueryShouldReturnListWhenThereIsSuchArea() throws TetrahedronException {
        //given
        final double minArea = 40;
        final double maxArea = 50;

        AreaSpecification areaSpecification = new AreaSpecification(minArea, maxArea);

        TetrahedronRepositoryImpl repository = new TetrahedronRepositoryImpl();
        repository.addTetrahedron(FIRST);
        repository.addTetrahedron(SECOND);
        repository.addTetrahedron(THIRD);
        repository.addTetrahedron(FOURTH);
        repository.addTetrahedron(FIFTH);
        repository.addTetrahedron(SIXTH);

        //when
        List<TetrahedronIdentifiable> actual = repository.query(areaSpecification);

        //then
        List<TetrahedronIdentifiable> expected = Arrays.asList(FOURTH, FIFTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testQueryShouldReturnListWhenThereIsSuchVolume() throws TetrahedronException {
        //given
        final double minVolume = 10;
        final double maxVolume = 20;

        VolumeSpecification volumeSpecification = new VolumeSpecification(minVolume, maxVolume);

        TetrahedronRepositoryImpl repository = new TetrahedronRepositoryImpl();
        repository.addTetrahedron(FIRST);
        repository.addTetrahedron(SECOND);
        repository.addTetrahedron(THIRD);
        repository.addTetrahedron(FOURTH);
        repository.addTetrahedron(FIFTH);
        repository.addTetrahedron(SIXTH);

        //when
        List<TetrahedronIdentifiable> actual = repository.query(volumeSpecification);

        //then
        List<TetrahedronIdentifiable> expected = Arrays.asList(FOURTH, FIFTH);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testSortByIdShouldSortWhenIsValid() throws TetrahedronException {
        //given
        TetrahedronRepositoryImpl repository = new TetrahedronRepositoryImpl();
        repository.addTetrahedron(FIRST);
        repository.addTetrahedron(SECOND);
        repository.addTetrahedron(THIRD);
        repository.addTetrahedron(FOURTH);
        repository.addTetrahedron(FIFTH);
        repository.addTetrahedron(SIXTH);


        //when
        List<TetrahedronIdentifiable> actual = repository.sort(TetrahedronComparator.ID.getComparator());

        //then
        List<TetrahedronIdentifiable> expected = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSortByAreaShouldSortWhenIsValid() throws TetrahedronException {
        //given
        TetrahedronRepositoryImpl repository = new TetrahedronRepositoryImpl();
        repository.addTetrahedron(FIRST);
        repository.addTetrahedron(SECOND);
        repository.addTetrahedron(THIRD);
        repository.addTetrahedron(FOURTH);
        repository.addTetrahedron(FIFTH);
        repository.addTetrahedron(SIXTH);

        TetrahedronStore store = TetrahedronStore.getInstance();

        store.update(FIRST);
        store.update(SECOND);
        store.update(THIRD);
        store.update(FOURTH);
        store.update(FIFTH);
        store.update(SIXTH);

        //when
        List<TetrahedronIdentifiable> actual = repository.sort(TetrahedronComparator.AREA.getComparator());

        //then
        List<TetrahedronIdentifiable> expected = Arrays.asList(SIXTH, FIRST, FIFTH, FOURTH, SECOND, THIRD);

        Assert.assertEquals(expected, actual);

    }
}
