package com.epam.shape.creator;

import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;

import java.util.List;

public interface TetrahedronCreator {
    List<Tetrahedron> createTetrahedronList(List<double[]> coordinatesList) throws TetrahedronException;

    Tetrahedron createTetrahedron(double[] coordinates) throws TetrahedronException;
}
