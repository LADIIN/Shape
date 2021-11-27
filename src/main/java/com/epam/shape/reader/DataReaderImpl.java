package com.epam.shape.reader;

import com.epam.shape.exception.TetrahedronException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    @Override
    public List<String> read(String path) throws TetrahedronException {
        if (path == null || path.isEmpty()) {
            throw new TetrahedronException("File path is empty or null.");
        }
        List<String> data;
        Path filePath = Paths.get(path);

        try (Stream<String> dataStream = Files.lines(filePath)) {
            data = dataStream.collect(Collectors.toList());
        } catch (IOException exception) {
            throw new TetrahedronException(String.format("There is no file: %s", path), exception);
        }

        return data;
    }
}
