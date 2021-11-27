package com.epam.shape.service;

import com.epam.shape.entity.Tetrahedron;

public interface TetrahedronService {
    double calculateArea(Tetrahedron tetrahedron);
    double calculateVolume(Tetrahedron tetrahedron);
}
