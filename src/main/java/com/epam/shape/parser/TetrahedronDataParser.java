package com.epam.shape.parser;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.validator.TetrahedronValidatorImpl;

import java.util.ArrayList;
import java.util.List;


public class TetrahedronDataParser {
    private static final String SPACE_DELIMITER_REGEX = "\\s+";
    private final String TETRAHEDRON_REGEX = "^\\s*(-?\\d+(\\.\\d+)?\\s+){11}-?\\d+(\\.\\d+)?\\s*$";

    public List<double[]> parseStringDataToListOfDoubleArrays(List<String> data) throws TetrahedronException {
        if (data == null || data.isEmpty()) {
            throw new TetrahedronException("List is empty or null");
        }

        TetrahedronValidatorImpl tetrahedronValidator = new TetrahedronValidatorImpl();

        List<double[]> coordinatesList = new ArrayList<>();

        for (String line : data) {
            line = line.trim();

            if (tetrahedronValidator.isTetrahedronData(line)) {

                String[] doubleStrings = line.split(SPACE_DELIMITER_REGEX);

                double[] array = new double[doubleStrings.length];

                for (int i = 0; i < array.length; i++) {
                    array[i] = Double.parseDouble(doubleStrings[i]);
                }

                coordinatesList.add(array);

            }
        }

        return coordinatesList;

    }
}
