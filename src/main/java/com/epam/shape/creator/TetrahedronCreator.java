package com.epam.shape.creator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.TetrahedronValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;


public class TetrahedronCreator {
    private static final int VALID_AMOUNT_OF_COORDINATES = 12;
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    private static final TetrahedronValidator tetrahedronValidator = new TetrahedronValidator();

    public Optional<Tetrahedron> createTetrahedron(double[] coordinates) throws TetrahedronException {
        if (coordinates == null || coordinates.length != VALID_AMOUNT_OF_COORDINATES) {
            throw new TetrahedronException("Array is null or there is wrong amount of coordinates");
        }
        Optional<Tetrahedron> optionalTetrahedron;

        Point pointA = new Point(coordinates[0], coordinates[1], coordinates[2]);
        Point pointB = new Point(coordinates[3], coordinates[4], coordinates[5]);
        Point pointC = new Point(coordinates[6], coordinates[7], coordinates[8]);
        Point pointD = new Point(coordinates[9], coordinates[10], coordinates[11]);

        if (tetrahedronValidator.isPossible(pointA, pointB, pointC, pointD)) {
            Tetrahedron tetrahedron = new Tetrahedron(pointA, pointB, pointC, pointD);

            optionalTetrahedron = Optional.of(tetrahedron);

            LOGGER.log(Level.INFO, "Creating Tetrahedron is successful");

        } else {
            optionalTetrahedron = Optional.empty();
        }
        return optionalTetrahedron;
    }
}
