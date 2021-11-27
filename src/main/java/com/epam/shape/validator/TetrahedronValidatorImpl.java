package com.epam.shape.validator;

import com.epam.shape.entity.Point;

public class TetrahedronValidatorImpl implements TetrahedronValidator {
    private static final String TETRAHEDRON_REGEX = "^\\s*(-?\\d+(\\.\\d+)?\\s+){11}-?\\d+(\\.\\d+)?\\s*$";

    @Override
    public boolean isTetrahedronPossible(Point pointA, Point pointB, Point pointC, Point pointD) {
        Point vectorAB = calculateCoordinates(pointA, pointB);
        Point vectorAC = calculateCoordinates(pointA, pointC);
        Point vectorAD = calculateCoordinates(pointA, pointD);

        double vectorBasis = calculateVectorBasis(vectorAB, vectorAC, vectorAD);

        return vectorBasis != 0;
    }

    @Override
    public boolean isTetrahedronData(String data) {
        return data.matches(TETRAHEDRON_REGEX);
    }

    private Point calculateCoordinates(Point pointA, Point pointB) {
        double x = pointA.getX() - pointB.getX();
        double y = pointA.getY() - pointB.getY();
        double z = pointA.getZ() - pointB.getZ();

        return new Point(x, y, z);
    }

    public double calculateVectorBasis(Point vectorA, Point vectorB, Point vectorC) {
        return vectorA.getX() * vectorB.getY() * vectorC.getZ() +
                vectorA.getY() * vectorB.getZ() * vectorC.getX() +
                vectorA.getZ() * vectorB.getX() * vectorC.getY() -
                vectorA.getZ() * vectorB.getY() * vectorC.getX() -
                vectorA.getY() * vectorB.getX() * vectorC.getZ() -
                vectorA.getX() * vectorB.getZ() * vectorC.getY();
    }

}
