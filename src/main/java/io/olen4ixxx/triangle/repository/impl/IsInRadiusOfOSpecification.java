package io.olen4ixxx.triangle.repository.impl;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.repository.CustomSpecification;

public class IsInRadiusOfOSpecification implements CustomSpecification {
    double radius;

    public IsInRadiusOfOSpecification(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specify(CustomTriangle triangle) {
        CustomPoint vertexOne = triangle.getVertexOne();
        CustomPoint vertexTwo = triangle.getVertexTwo();
        CustomPoint vertexThree = triangle.getVertexThree();
        return Math.hypot(vertexOne.getX(), vertexOne.getY()) < radius
                && Math.hypot(vertexTwo.getX(), vertexTwo.getY()) < radius
                && Math.hypot(vertexThree.getX(), vertexThree.getY()) < radius;
    }
}
