package com.epam.shape.reader.impl;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.reader.DataReader;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataReaderImpl implements DataReader {
    private static final Logger LOGGER = LogManager.getLogger(DataReaderImpl.class.getName());

    @Override
    public List<String> read(String path) throws TetrahedronException {
        if (path == null || path.isEmpty()) {
            throw new TetrahedronException("File path is empty or null.");
        }
        List<String> data = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
            }

            LOGGER.log(Level.INFO, String.format("File %s read successfully.", path));

        } catch (IOException e) {
            LOGGER.log(Level.ERROR, String.format("There is no file: %s", path), e);

            throw new TetrahedronException(String.format("There is no file: %s", path), e);
        }

        return data;
    }

}
