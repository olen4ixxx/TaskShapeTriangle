package io.olen4ixxx.triangle.parser;

import io.olen4ixxx.triangle.exception.CustomTriangleException;

import java.util.List;

public interface CustomParser {
    List<double[]> parseLinesToTriangleCoordinates(List<String> lines) throws CustomTriangleException;
}
