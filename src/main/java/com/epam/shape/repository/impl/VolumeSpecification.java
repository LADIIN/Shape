package com.epam.shape.repository.impl;

import com.epam.shape.calculator.TetrahedronCalculator;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.repository.TetrahedronSpecification;

public class VolumeSpecification implements TetrahedronSpecification {
    private final double minVolume;
    private final double maxVolume;

    private final TetrahedronCalculator calculator = new TetrahedronCalculator();

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(TetrahedronIdentifiable tetrahedron) throws TetrahedronException {
        double volume = calculator.calculateVolume(tetrahedron);

        return volume >= minVolume && volume <= maxVolume;
    }
}
