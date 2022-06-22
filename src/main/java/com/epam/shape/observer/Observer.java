package com.epam.shape.observer;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;

public interface Observer {
    void update(TetrahedronIdentifiable tetrahedron) throws TetrahedronException;
}
