package io.olen4ixxx.triangle.repository.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.repository.CustomSpecification;

public class IdSpecification implements CustomSpecification {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomTriangle triangle) {
        return triangle.getTriangleId() == id;
    }
}
