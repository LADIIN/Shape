package com.epam.shape.parser;

import com.epam.shape.exception.TetrahedronException;

import java.util.List;

public interface TetrahedronDataParser {
    List<double[]> parseStringToDouble(List<String> data) throws TetrahedronException;
}
