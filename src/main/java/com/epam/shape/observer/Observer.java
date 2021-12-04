package com.epam.shape.observer;

import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;

public interface Observer {
    void update(TetrahedronIdentifiable tetrahedron) throws TetrahedronException;
}
