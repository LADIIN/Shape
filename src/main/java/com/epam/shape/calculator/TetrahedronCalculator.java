package com.epam.shape.calculator;


import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.impl.DataReaderImpl;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;

public class TetrahedronCalculator {
    private static final VectorCalculator vectorCalculator = new VectorCalculator();
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    public double calculateArea(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Object Tetrahedron is null.");
        }

        Point vectorAB = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointB());
        Point vectorAC = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointC());
        Point vectorAD = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointD());
        Point vectorBC = vectorCalculator.calculateCoordinates(tetrahedron.getPointB(), tetrahedron.getPointC());
        Point vectorBD = vectorCalculator.calculateCoordinates(tetrahedron.getPointB(), tetrahedron.getPointD());

        double sideABC = calculateSideArea(vectorAB, vectorAC);
        double sideABD = calculateSideArea(vectorAB, vectorAD);
        double sideACD = calculateSideArea(vectorAC, vectorAD);
        double sideBCD = calculateSideArea(vectorBC, vectorBD);

        double area = sideABC + sideABD + sideACD + sideBCD;

        LOGGER.log(Level.INFO, String.format("Calculated Tetrahedron area: %f", area));

        return area;
    }

    public double calculateVolume(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Object Tetrahedron is null.");
        }

        Point vectorAB = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointB());
        Point vectorAC = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointC());
        Point vectorAD = vectorCalculator.calculateCoordinates(tetrahedron.getPointA(), tetrahedron.getPointD());

        double determinant = calculateDeterminant(vectorAB, vectorAC, vectorAD);

        double volume = Math.abs(determinant / 6);

        LOGGER.log(Level.INFO, String.format("Calculated Tetrahedron volume: %f", volume));

        return volume;
    }

    //Assuming that intersection points of axis we already know.
    public double calculateVolumeRation(Tetrahedron tetrahedron, Point intersectionA,
                                        Point intersectionB, Point intersectionC) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Object Tetrahedron is null.");
        }

        Tetrahedron smallTetrahedron = new Tetrahedron(intersectionA,
                intersectionB, intersectionC, tetrahedron.getPointD());

        double firstPartVolume = calculateVolume(smallTetrahedron);
        double secondPartVolume = calculateVolume(tetrahedron) - firstPartVolume;

        return firstPartVolume / secondPartVolume;
    }


    private double calculateDeterminant(Point vectorA, Point vectorB, Point vectorC) throws TetrahedronException {
        if (vectorA == null || vectorB == null || vectorC == null) {
            throw new TetrahedronException("Point is null");
        }

        return vectorA.getX() * (vectorB.getY() * vectorC.getZ() - vectorC.getY() * vectorB.getZ())
                - vectorB.getX() * (vectorA.getY() * vectorC.getZ() - vectorC.getY() * vectorA.getZ())
                + vectorC.getX() * (vectorA.getY() * vectorB.getZ() - vectorB.getY() * vectorA.getZ());
    }

    private double calculateSideArea(Point vectorA, Point vectorB) throws TetrahedronException {
        if (vectorA == null || vectorB == null) {
            throw new TetrahedronException("Point is null");
        }

        double sideA = Math.sqrt(Math.pow(vectorA.getX(), 2) + Math.pow(vectorA.getY(), 2)
                + Math.pow(vectorA.getZ(), 2));

        double sideB = Math.sqrt(Math.pow(vectorB.getX(), 2) + Math.pow(vectorB.getY(), 2)
                + Math.pow(vectorB.getZ(), 2));

        double cosine = (vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY()
                + vectorA.getZ() * vectorB.getZ()) / (sideA * sideB);

        double sinus = Math.sqrt(1 - Math.pow(cosine, 2));

        return sideA * sideB * sinus / 2;
    }

}
