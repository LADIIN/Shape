package com.epam.shape.calculator;

import com.epam.shape.entity.Point;
import com.epam.shape.exception.TetrahedronException;

public class VectorCalculator {
        public  Point calculateCoordinates(Point pointA, Point pointB) throws TetrahedronException {
        if (pointA == null || pointB == null) {
            throw new TetrahedronException("Point is null");
        }

        double x = pointA.getX() - pointB.getX();
        double y = pointA.getY() - pointB.getY();
        double z = pointA.getZ() - pointB.getZ();

        return new Point(x, y, z);
    }
}
