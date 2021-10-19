package io.olen4ixxx.triangle.repository.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.repository.CustomSpecification;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;

public class SquareIsBetweenSpecification implements CustomSpecification {
    double min;
    double max;

    public SquareIsBetweenSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(CustomTriangle triangle) {
        TriangleCalculation calculation = new TriangleCalculationService();
        double square = calculation.triangleSquare(triangle);
        return square > min && square < max;
    }
}
