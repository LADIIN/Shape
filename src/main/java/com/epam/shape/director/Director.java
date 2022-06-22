package com.epam.shape.director;

import com.epam.shape.creator.TetrahedronCreator;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.parser.TetrahedronDataParser;
import com.epam.shape.reader.impl.DataReaderImpl;
import com.epam.shape.validator.TetrahedronLineValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Director {
    private static final Logger LOGGER = Logger.getLogger(Director.class.getName());

    private final DataReaderImpl dataReader;
    private final TetrahedronCreator tetrahedronCreator;
    private final TetrahedronDataParser tetrahedronParser;
    private final TetrahedronLineValidator lineValidator;

    public Director(DataReaderImpl dataReader, TetrahedronCreator tetrahedronCreator,
                    TetrahedronDataParser tetrahedronParser, TetrahedronLineValidator lineValidator) {
        this.dataReader = dataReader;
        this.tetrahedronCreator = tetrahedronCreator;
        this.tetrahedronParser = tetrahedronParser;
        this.lineValidator = lineValidator;
    }

    public List<Tetrahedron> createTetrahedrons(String path) throws TetrahedronException {
        List<String> data = dataReader.read(path);
        List<Tetrahedron> tetrahedrons = new ArrayList<>();

        for (String line : data) {
            if (lineValidator.isValid(line)) {
                double[] coordinates = tetrahedronParser.parseStringToDouble(line);

                Optional<Tetrahedron> tetrahedron = tetrahedronCreator.createTetrahedron(coordinates);

                tetrahedron.ifPresent(tetrahedrons::add);
            }
        }
        LOGGER.log(Level.INFO, "All Tetrahedrons have been created.");

        return tetrahedrons;
    }

}
