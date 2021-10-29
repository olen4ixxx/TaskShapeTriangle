package io.olen4ixxx.triangle.comparator;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.Comparator;

public class CustomXComparator implements Comparator<CustomTriangle> {
    @Override
    public int compare(CustomTriangle triangle1, CustomTriangle triangle2) {
        double max1 = maxX(triangle1);
        double max2 = maxX(triangle2);
        return Double.compare(max1, max2);
    }

    private double maxX(CustomTriangle triangle) {
        CustomPoint vertexOne = triangle.getVertexOne();
        CustomPoint vertexTwo = triangle.getVertexTwo();
        CustomPoint vertexThree = triangle.getVertexThree();
        double x1 = vertexOne.getX();
        double x2 = vertexTwo.getX();
        double x3 = vertexThree.getX();
        return Math.max(x1, Math.max(x2, x3));
    }
}
