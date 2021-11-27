package com.epam.shape.validator;

public class DataStringValidator {
    private final String TETRAHEDRON_REGEX = "^\\s*(-?\\d+(\\.\\d+)?\\s+){11}-?\\d+(\\.\\d+)?\\s*$";

    public boolean isValid(String data) {
        return data.matches(TETRAHEDRON_REGEX);
    }
}
