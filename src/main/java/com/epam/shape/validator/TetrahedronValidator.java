package com.epam.shape.validator;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;

public interface TetrahedronValidator {
    boolean isPossible(Point pointA, Point pointB, Point pointC, Point pointD) throws TetrahedronException;

    boolean isPossible(Tetrahedron tetrahedron) throws TetrahedronException;
}
