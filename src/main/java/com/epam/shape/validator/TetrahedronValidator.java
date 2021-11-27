package com.epam.shape.validator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public interface TetrahedronValidator {
    boolean isTetrahedronPossible(Point pointA, Point pointB, Point pointC, Point pointD);

    boolean isTetrahedronPossible(Tetrahedron tetrahedron);

    boolean isTetrahedronData(String data);
}
