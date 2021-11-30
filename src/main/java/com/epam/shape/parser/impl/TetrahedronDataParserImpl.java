package com.epam.shape.parser.impl;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.parser.TetrahedronDataParser;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.DataStringValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TetrahedronDataParserImpl implements TetrahedronDataParser {
    private static final String SPACE_DELIMITER_REGEX = "\\s+";
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    private final DataStringValidator dataStringValidator = new DataStringValidator();

    public List<double[]> parseStringToDouble(List<String> data) throws TetrahedronException {
        if (data == null || data.isEmpty()) {
            throw new TetrahedronException("List is empty or null");
        }

        List<double[]> coordinatesList = new ArrayList<>();

        for (String line : data) {
            line = line.trim();

            if (dataStringValidator.isValid(line)) {
                String[] doubleStrings = line.split(SPACE_DELIMITER_REGEX);

                double[] array = new double[doubleStrings.length];

                for (int i = 0; i < array.length; i++) {
                    array[i] = Double.parseDouble(doubleStrings[i]);
                }

                coordinatesList.add(array);
            }
        }

        LOGGER.log(Level.INFO, "Parsing is successful.");

        return coordinatesList;

    }
}
