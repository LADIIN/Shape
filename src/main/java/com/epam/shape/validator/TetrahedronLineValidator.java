package com.epam.shape.validator;

import com.epam.shape.exception.TetrahedronException;

public class TetrahedronLineValidator {
    private final String TETRAHEDRON_REGEX = "^\\s*(-?\\d+(\\.\\d+)?\\s+){11}-?\\d+(\\.\\d+)?\\s*$";

    public boolean isValid(String data) throws TetrahedronException {
        if (data == null) {
            throw new TetrahedronException("String is empty or null.");
        }
        return data.matches(TETRAHEDRON_REGEX);
    }
}
