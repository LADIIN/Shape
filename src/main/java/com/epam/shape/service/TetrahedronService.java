package com.epam.shape.service;

import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;

public interface TetrahedronService {
    double calculateArea(Tetrahedron tetrahedron) throws TetrahedronException;
    double calculateVolume(Tetrahedron tetrahedron) throws TetrahedronException;
}
