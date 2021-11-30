package com.epam.shape.creator.impl;

import com.epam.shape.creator.TetrahedronCreator;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.impl.TetrahedronValidatorImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TetrahedronCreatorImpl implements TetrahedronCreator {
    private static final int VALID_AMOUNT_OF_COORDINATES = 12;
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    private static final TetrahedronValidatorImpl tetrahedronValidator = new TetrahedronValidatorImpl();

    @Override
    public List<Tetrahedron> createTetrahedronList(List<double[]> coordinatesList) throws TetrahedronException {
        if (coordinatesList == null || coordinatesList.isEmpty()) {
            throw new TetrahedronException("List is empty or null");
        }

        List<Tetrahedron> tetrahedrons = new ArrayList<>();

        for (double[] coordinates : coordinatesList) {
            Tetrahedron tetrahedron = createTetrahedron(coordinates);

            if (tetrahedronValidator.isPossible(tetrahedron)) {
                tetrahedrons.add(tetrahedron);
            }
        }

        LOGGER.log(Level.INFO, "Creating list of Tetrahedron is successful.");

        return tetrahedrons;
    }

    @Override
    public Tetrahedron createTetrahedron(double[] coordinates) throws TetrahedronException {
        if (coordinates == null || coordinates.length != VALID_AMOUNT_OF_COORDINATES) {
            throw new TetrahedronException("Array is null or there is wrong amount of coordinates");
        }

        LOGGER.log(Level.INFO, "Creating Tetrahedron is successful");

        return new Tetrahedron(new Point(coordinates[0], coordinates[1], coordinates[2]),
                new Point(coordinates[3], coordinates[4], coordinates[5]),
                new Point(coordinates[6], coordinates[7], coordinates[8]),
                new Point(coordinates[9], coordinates[10], coordinates[11]));
    }
}
