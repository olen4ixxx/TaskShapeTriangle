package io.olen4ixxx.triangle.validator;

import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.List;

public class CustomTriangleValidator {
    private static CustomTriangleValidator instance;
    private static final String REGEX_NUMERIC = "[-]?\\d+\\.\\d+";
    private static final String TRIANGLE_VERTICES_SIX_COORDINATES = "([-]?\\d+[.]\\d+\\s+){5}[-]?\\d+[.]\\d+\\s*";

    private CustomTriangleValidator() {
    }

    public static CustomTriangleValidator getInstance() {
        if (instance == null) {
            instance = new CustomTriangleValidator();
        }
        return instance;
    }

    public boolean isArrayOfSixCoordinates(double[] array) {
        return array != null && array.length == 6;
    }

    public boolean isLineOfCoordinates(String str) {
        return str != null && str.matches(TRIANGLE_VERTICES_SIX_COORDINATES);
    }

    public boolean isNumeric(String str) {
        return str != null && str.matches(REGEX_NUMERIC);
    }

    public boolean isEmptyOrNull(List<?> list) {
        return list == null || list.isEmpty();
    }

    public boolean isTriangle(CustomTriangle customTriangle) {
        double x1 = customTriangle.getVertexOne().getX();
        double x2 = customTriangle.getVertexTwo().getX();
        double x3 = customTriangle.getVertexThree().getX();
        double y1 = customTriangle.getVertexOne().getY();
        double y2 = customTriangle.getVertexTwo().getY();
        double y3 = customTriangle.getVertexThree().getY();
        return Double.compare((x3 - x1) * (y2 - y1), (x2 - x1) * (y3 - y1)) != 0;
    }

    public boolean isTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Double.compare((x3 - x1) * (y2 - y1), (x2 - x1) * (y3 - y1)) != 0;
    }
}
