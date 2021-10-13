package io.olen4ixxx.triangle;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;
import io.olen4ixxx.triangle.validator.CustomTriangleValidator;

public class Main {
    public static void main(String[] args) {
        CustomPoint point1 = new CustomPoint(0.0,0.0);
        CustomPoint point2 = new CustomPoint(10,0);
        CustomPoint point3 = new CustomPoint(5,5 * Math.sqrt(3));
        CustomTriangle customTriangle = new CustomTriangle(point1, point2, point3);
        System.out.println(point1);
        CustomTriangleValidator validator = new CustomTriangleValidator();
        System.out.println("isTriangle: " + validator.isTriangle(customTriangle));

        TriangleCalculation triangleCalculation = new TriangleCalculationService();
        System.out.println("P: " + triangleCalculation.trianglePerimeter(customTriangle));
        System.out.println("S: " + triangleCalculation.triangleSquare(customTriangle));
        System.out.println("isRight: " + triangleCalculation.isRight(customTriangle));
        System.out.println("isAcute: " + triangleCalculation.isAcute(customTriangle));
        System.out.println("isObtuse: " + triangleCalculation.isObtuse(customTriangle));
        System.out.println("isRegular: " + triangleCalculation.isRegular(customTriangle));
        System.out.println("isIsosceles: " + triangleCalculation.isIsosceles(customTriangle));
    }
}
