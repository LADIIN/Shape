package com.epam.shape.repository.impl;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.repository.TetrahedronRepository;
import com.epam.shape.repository.TetrahedronSpecification;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
    private static final Logger LOGGER = Logger.getLogger(TetrahedronRepositoryImpl.class.getName());

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

                LOGGER.log(Level.INFO, String.format("Tetrahedron id = %d was added to query result.",
                        tetrahedron.getId()));
            }
        }

        return tetrahedrons;
    }

    @Override
    public List<TetrahedronIdentifiable> sort(Comparator<TetrahedronIdentifiable> comparator) {
        List<TetrahedronIdentifiable> tetrahedrons = new ArrayList<>(store.values());

        tetrahedrons.sort(comparator);

        LOGGER.log(Level.INFO, "Tetrahedrons have been sorted.");

        return tetrahedrons;
    }


}
