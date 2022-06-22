package com.epam.shape.repository.impl;

import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.repository.TetrahedronSpecification;

public class IdSpecification implements TetrahedronSpecification {

    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(TetrahedronIdentifiable tetrahedron) {
        return tetrahedron.getId().equals(id);
    }
}
