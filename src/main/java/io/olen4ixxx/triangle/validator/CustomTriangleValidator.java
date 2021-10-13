package io.olen4ixxx.triangle.validator;

import io.olen4ixxx.triangle.entity.CustomTriangle;

public class CustomTriangleValidator {
    public boolean isTriangle(CustomTriangle customTriangle) {
        double x1 = customTriangle.getVertexOne().getX();
        double x2 = customTriangle.getVertexTwo().getX();
        double x3 = customTriangle.getVertexThree().getX();
        double y1 = customTriangle.getVertexOne().getY();
        double y2 = customTriangle.getVertexTwo().getY();
        double y3 = customTriangle.getVertexThree().getY();
        return Double.compare((x3 - x1) * (y2 - y1), (x2 - x1) * (y3 - y1)) !=0;
    }
}
