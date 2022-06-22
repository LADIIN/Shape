package com.epam.shape.entity;

import java.util.Objects;

public class Point {
    private static final double DELTA = 0.0001;

    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Point point = (Point) object;

        return Math.abs(point.getX() - x) < DELTA
                && Math.abs(point.getY() - y) < DELTA
                && Math.abs(point.getZ() - z) < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", x, y, z);
    }

}
