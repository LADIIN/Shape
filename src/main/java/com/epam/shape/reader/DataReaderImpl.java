package com.epam.shape.reader;

import com.epam.shape.exception.TetrahedronException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataReaderImpl implements DataReader {

    @Override
    public List<String> read(String path) throws TetrahedronException {
        if (path == null || path.isEmpty()) {
            throw new TetrahedronException("File path is empty or null.");
        }
        List<String> data = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src/main/java/resources/data.txt");
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
            }

        } catch (IOException e) {
            throw new TetrahedronException(String.format("There is no file: %s", path), e);
        }

        return data;
    }

}
