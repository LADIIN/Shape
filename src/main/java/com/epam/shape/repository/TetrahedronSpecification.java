package com.epam.shape.repository;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;

public interface TetrahedronSpecification {
    boolean specified(TetrahedronIdentifiable tetrahedron) throws TetrahedronException;
}
