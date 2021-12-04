package com.epam.shape.observer;

import com.epam.shape.calculator.TetrahedronCalculator;
import com.epam.shape.exception.TetrahedronException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

public class TetrahedronStore implements Observer {
    private static final Logger LOGGER = Logger.getLogger(TetrahedronStore.class);

    private final Map<Integer, TetrahedronParameters> parameters = new HashMap<>();

    //became not final for setter in TetrahedronStoreTest
    private TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
    private static TetrahedronStore instance;

    private TetrahedronStore() {
    }

    public static TetrahedronStore getInstance() {
        if (instance == null) {
            instance = new TetrahedronStore();
        }
        return instance;
    }

    @Override
    public void update(TetrahedronIdentifiable tetrahedron) throws TetrahedronException {
        double area = tetrahedronCalculator.calculateArea(tetrahedron);
        double volume = tetrahedronCalculator.calculateVolume(tetrahedron);

        parameters.put(tetrahedron.getId(), new TetrahedronParameters(area, volume));

        LOGGER.log(Level.INFO, String.format("Tetrahedron id = %d have been updated.", tetrahedron.getId()));
    }

    public Map<Integer, TetrahedronParameters> getParameters() {
        return parameters;
    }

    //Have been added for TetrahedronStoreTest
    public void setTetrahedronCalculator(TetrahedronCalculator tetrahedronCalculator) {
        this.tetrahedronCalculator = tetrahedronCalculator;
    }

}
