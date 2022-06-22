package com.epam.shape.parser;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.TetrahedronLineValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class TetrahedronDataParser {
    private static final String SPACE_DELIMITER_REGEX = "\\s+";
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    private final TetrahedronLineValidator tetrahedronLineValidator = new TetrahedronLineValidator();

    public double[] parseStringToDouble(String line) throws TetrahedronException {
        if (line == null || line.isEmpty()) {
            throw new TetrahedronException("String is empty or null");
        }

        line = line.trim();

        String[] doubleStrings = line.split(SPACE_DELIMITER_REGEX);

        double[] coordinates = new double[doubleStrings.length];

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Double.parseDouble(doubleStrings[i]);
        }

        LOGGER.log(Level.INFO, "Line parsing is successful.");

        return coordinates;

    }
}
