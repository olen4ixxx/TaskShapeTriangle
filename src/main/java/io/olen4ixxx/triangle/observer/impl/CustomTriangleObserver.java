package io.olen4ixxx.triangle.observer.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.observer.CustomObserver;
import io.olen4ixxx.triangle.observer.CustomTriangleEvent;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;
import io.olen4ixxx.triangle.warehouse.CustomWarehouse;

public class CustomTriangleObserver implements CustomObserver {
    @Override
    public void parameterChange(CustomTriangleEvent event) {
        TriangleCalculation calculation = new TriangleCalculationService();
        CustomTriangle triangle = event.getSource();
        double perimeter = calculation.trianglePerimeter(triangle);
        double square = calculation.triangleSquare(triangle);
        CustomWarehouse warehouse = CustomWarehouse.getInstance();
        warehouse.updateParameters(triangle.getTriangleId(), perimeter, square);
    }
}
