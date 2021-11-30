package com.epam.shape.director;

import com.epam.shape.creator.impl.TetrahedronCreatorImpl;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.parser.impl.TetrahedronDataParserImpl;
import com.epam.shape.reader.impl.DataReaderImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Director {
    private static final Logger LOGGER = Logger.getLogger(Director.class.getName());

    private static final DataReaderImpl dataReader = new DataReaderImpl();
    private static final TetrahedronCreatorImpl tetrahedronCreator = new TetrahedronCreatorImpl();
    private static final TetrahedronDataParserImpl tetrahedronParser = new TetrahedronDataParserImpl();

    public List<Tetrahedron> getTetrahedrons(String path) throws TetrahedronException {
        List<String> data = dataReader.read(path);

        List<double[]> coordinates = tetrahedronParser.parseStringToDouble(data);

        List<Tetrahedron> tetrahedrons = tetrahedronCreator.createTetrahedronList(coordinates);

        LOGGER.log(Level.INFO, "All Tetrahedrons have been created.");

        return tetrahedrons;
    }

}
