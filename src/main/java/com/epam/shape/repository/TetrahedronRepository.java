package com.epam.shape.repository;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;

import java.util.Comparator;
import java.util.List;

public interface TetrahedronRepository {
    void addTetrahedron(TetrahedronIdentifiable tetrahedron);

    void removeTetrahedron(TetrahedronIdentifiable tetrahedron);

    void updateTetrahedron(TetrahedronIdentifiable tetrahedron);

    List<TetrahedronIdentifiable> query(TetrahedronSpecification specification) throws TetrahedronException;

    List<TetrahedronIdentifiable> sort(Comparator<TetrahedronIdentifiable> comparator);

}
