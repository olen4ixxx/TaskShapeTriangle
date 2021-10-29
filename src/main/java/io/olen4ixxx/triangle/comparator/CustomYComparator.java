package io.olen4ixxx.triangle.comparator;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.Comparator;

public class CustomYComparator implements Comparator<CustomTriangle> {
    @Override
    public int compare(CustomTriangle triangle1, CustomTriangle triangle2) {
        double max1 = maxY(triangle1);
        double max2 = maxY(triangle2);
        return Double.compare(max1, max2);
    }

    private double maxY(CustomTriangle triangle) {
        CustomPoint vertexOne = triangle.getVertexOne();
        CustomPoint vertexTwo = triangle.getVertexTwo();
        CustomPoint vertexThree = triangle.getVertexThree();
        double y1 = vertexOne.getY();
        double y2 = vertexTwo.getY();
        double y3 = vertexThree.getY();
        return Math.max(y1, Math.max(y2, y3));
    }
}
