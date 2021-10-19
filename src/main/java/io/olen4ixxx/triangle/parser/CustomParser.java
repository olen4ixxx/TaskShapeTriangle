package io.olen4ixxx.triangle.parser;

import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.List;

public interface CustomParser {
    CustomTriangle parseLinesToTriangle(List<String> lines);
}
