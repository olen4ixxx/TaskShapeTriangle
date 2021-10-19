package io.olen4ixxx.triangle.filereader;

import io.olen4ixxx.triangle.exception.CustomTriangleException;

import java.util.List;

public interface TriangleReader {
    List<String> readLines(String stringPath) throws CustomTriangleException;
}
