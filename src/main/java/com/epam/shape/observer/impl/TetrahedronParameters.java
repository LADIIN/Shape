package com.epam.shape.observer.impl;

public class TetrahedronParameters {
    private final double surfaceArea;
    private final double volume;

    public TetrahedronParameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }
}
