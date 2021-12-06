package com.epam.shape.repository.impl;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.repository.TetrahedronRepository;
import com.epam.shape.repository.TetrahedronSpecification;

import java.util.*;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {

    private Map<Integer, TetrahedronIdentifiable> store = new HashMap<>();

    @Override
    public void addTetrahedron(TetrahedronIdentifiable tetrahedron) {
        store.put(tetrahedron.getId(), tetrahedron);
    }

    @Override
    public void removeTetrahedron(TetrahedronIdentifiable tetrahedron) {
        store.remove(tetrahedron.getId());
    }

    @Override
    public void updateTetrahedron(TetrahedronIdentifiable tetrahedron) {
        store.put(tetrahedron.getId(), tetrahedron);
    }

    @Override
    public List<TetrahedronIdentifiable> query(TetrahedronSpecification specification) throws TetrahedronException {
        List<TetrahedronIdentifiable> tetrahedrons = new ArrayList<>();

        for (TetrahedronIdentifiable tetrahedron : store.values()) {
            if (specification.specified(tetrahedron)) {
                tetrahedrons.add(tetrahedron);
            }
        }

        return tetrahedrons;
    }

    @Override
    public List<TetrahedronIdentifiable> sort(Comparator<TetrahedronIdentifiable> comparator) {
        List<TetrahedronIdentifiable> tetrahedrons = new ArrayList<>(store.values());

        tetrahedrons.sort(comparator);

        return tetrahedrons;
    }


}
