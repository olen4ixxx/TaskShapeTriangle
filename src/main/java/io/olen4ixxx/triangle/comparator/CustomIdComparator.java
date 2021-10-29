package io.olen4ixxx.triangle.comparator;

import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.Comparator;

public class CustomIdComparator implements Comparator<CustomTriangle> {
    @Override
    public int compare(CustomTriangle triangle1, CustomTriangle triangle2) {
        return triangle1.getTriangleId() - triangle2.getTriangleId();
    }
}
