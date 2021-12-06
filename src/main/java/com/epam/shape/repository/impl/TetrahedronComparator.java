package com.epam.shape.repository.impl;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.observer.impl.TetrahedronStore;

import java.util.Comparator;

import static java.util.Comparator.nullsLast;

public enum TetrahedronComparator {
    ID,
    AREA,
    VOLUME;

    public Comparator<TetrahedronIdentifiable> getComparator() throws TetrahedronException {
        switch (this) {
            case ID:
                return nullsLast(Comparator.comparing(TetrahedronIdentifiable::getId));
            case AREA:
                return nullsLast(Comparator.comparingDouble(tetrahedron ->
                        TetrahedronStore.getInstance().getTetrahedronParameters(tetrahedron.getId()).getSurfaceArea()));
            case VOLUME:
                return nullsLast(Comparator.comparingDouble(tetrahedron ->
                        TetrahedronStore.getInstance().getTetrahedronParameters(tetrahedron.getId()).getVolume()));
            default:
                throw new TetrahedronException("Unresolved comparator.");
        }
    }


}
