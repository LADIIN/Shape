package com.epam.shape.repository.impl;

import com.epam.shape.calculator.TetrahedronCalculator;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.observer.impl.TetrahedronIdentifiable;
import com.epam.shape.repository.TetrahedronSpecification;

public class AreaSpecification implements TetrahedronSpecification {
    private final double minArea;
    private final double maxArea;
    private final TetrahedronCalculator calculator = new TetrahedronCalculator();

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(TetrahedronIdentifiable tetrahedron) throws TetrahedronException {
        double area = calculator.calculateArea(tetrahedron);

        return area >= minArea && area <= maxArea;
    }
}
