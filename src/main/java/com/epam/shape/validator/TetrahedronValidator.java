package com.epam.shape.validator;

import com.epam.shape.entity.Point;

public interface TetrahedronValidator {
    boolean isTetrahedronPossible(Point pointA, Point pointB, Point pointC, Point pointD);

    boolean isTetrahedronData(String data);
}
