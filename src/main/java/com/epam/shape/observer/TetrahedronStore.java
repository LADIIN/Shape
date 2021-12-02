package com.epam.shape.observer;

import com.epam.shape.calculator.TetrahedronCalculator;
import com.epam.shape.exception.TetrahedronException;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronStore {
    private final Map<Integer, TetrahedronParameters> parameters = new HashMap<>();
    private final TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
    private static TetrahedronStore instance;

    private TetrahedronStore() {
    }

    public static TetrahedronStore getInstance() {
        if (instance == null) {
            instance = new TetrahedronStore();
        }
        return instance;
    }

    private void update(TetrahedronIdentifiable tetrahedron) throws TetrahedronException {
        double area = tetrahedronCalculator.calculateArea(tetrahedron);
        double volume = tetrahedronCalculator.calculateVolume(tetrahedron);

        parameters.put(tetrahedron.getId(), new TetrahedronParameters(area, volume));

    }


}
