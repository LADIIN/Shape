package com.epam.shape.validator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.calculator.VectorCalculator;

public class TetrahedronValidator {
    private static final VectorCalculator vectorCalculator = new VectorCalculator();

    public boolean isPossible(Point pointA, Point pointB, Point pointC, Point pointD) throws TetrahedronException {
        if (pointA == null || pointB == null || pointC == null || pointD == null) {
            throw new TetrahedronException("Point is null");
        }
        Point vectorAB = vectorCalculator.calculateCoordinates(pointA, pointB);
        Point vectorAC = vectorCalculator.calculateCoordinates(pointA, pointC);
        Point vectorAD = vectorCalculator.calculateCoordinates(pointA, pointD);

        double vectorBasis = calculateVectorBasis(vectorAB, vectorAC, vectorAD);

        return vectorBasis != 0;
    }

    public boolean isPossible(Tetrahedron tetrahedron) throws TetrahedronException {
        if (tetrahedron == null) {
            throw new TetrahedronException("Tetrahedron is null");
        }

        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();
        Point pointD = tetrahedron.getPointD();

        return isPossible(pointA, pointB, pointC, pointD);
    }

    private double calculateVectorBasis(Point vectorA, Point vectorB, Point vectorC) throws TetrahedronException {
        if (vectorA == null || vectorB == null || vectorC == null) {
            throw new TetrahedronException("Point is null");
        }

        return vectorA.getX() * vectorB.getY() * vectorC.getZ() +
                vectorA.getY() * vectorB.getZ() * vectorC.getX() +
                vectorA.getZ() * vectorB.getX() * vectorC.getY() -
                vectorA.getZ() * vectorB.getY() * vectorC.getX() -
                vectorA.getY() * vectorB.getX() * vectorC.getZ() -
                vectorA.getX() * vectorB.getZ() * vectorC.getY();
    }

}
