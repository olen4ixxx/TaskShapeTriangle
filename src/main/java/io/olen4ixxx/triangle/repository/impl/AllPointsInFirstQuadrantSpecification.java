package io.olen4ixxx.triangle.repository.impl;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.repository.CustomSpecification;

public class AllPointsInFirstQuadrantSpecification implements CustomSpecification {
    @Override
    public boolean specify(CustomTriangle triangle) {
        CustomPoint vertexOne = triangle.getVertexOne();
        CustomPoint vertexTwo = triangle.getVertexTwo();
        CustomPoint vertexThree = triangle.getVertexThree();
        return vertexOne.getX() > 0 && vertexOne.getY() > 0
                && vertexTwo.getX() > 0 && vertexTwo.getY() > 0
                && vertexThree.getX() > 0 && vertexThree.getY() > 0;
    }
}
