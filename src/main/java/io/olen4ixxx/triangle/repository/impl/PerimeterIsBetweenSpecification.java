package io.olen4ixxx.triangle.repository.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.repository.CustomSpecification;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;

public class PerimeterIsBetweenSpecification implements CustomSpecification {
    double min;
    double max;

    public PerimeterIsBetweenSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(CustomTriangle triangle) {
        TriangleCalculation calculation = new TriangleCalculationService();
        double perimeter = calculation.trianglePerimeter(triangle);
        return perimeter > min && perimeter < max;
    }
}
