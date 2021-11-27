package com.epam.shape.reader;

import com.epam.shape.exception.TetrahedronException;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataReader {
    List<String> read(String path) throws TetrahedronException;

}
