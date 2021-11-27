package com.epam.shape.creator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;

import java.util.ArrayList;
import java.util.List;


public class TetrahedronCreatorImpl implements TetrahedronCreator {
    private final int VALID_AMOUNT_OF_COORDINATES = 12;

    @Override
    public List<Tetrahedron> createTetrahedronList(List<double[]> coordinatesList) throws TetrahedronException {
        if (coordinatesList == null || coordinatesList.isEmpty()) {
            throw new TetrahedronException("List is empty or null");
        }

        List<Tetrahedron> tetrahedrons = new ArrayList<>();

        for (double[] coordinates : coordinatesList) {
            Tetrahedron tetrahedron = createTetrahedron(coordinates);
            tetrahedrons.add(tetrahedron);
        }

        return tetrahedrons;
    }

    @Override
    public Tetrahedron createTetrahedron(double[] coordinates) throws TetrahedronException {
        if (coordinates == null || coordinates.length != VALID_AMOUNT_OF_COORDINATES) {
            throw new TetrahedronException("Array is null or there is wrong amount of coordinates");
        }

        return new Tetrahedron(new Point(coordinates[0], coordinates[1], coordinates[2]),
                new Point(coordinates[3], coordinates[4], coordinates[5]),
                new Point(coordinates[6], coordinates[7], coordinates[8]),
                new Point(coordinates[9], coordinates[10], coordinates[11]));
    }
}
