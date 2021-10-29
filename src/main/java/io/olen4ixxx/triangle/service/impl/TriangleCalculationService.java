package io.olen4ixxx.triangle.service.impl;

import io.olen4ixxx.triangle.entity.CustomPoint;
import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleCalculationService implements TriangleCalculation {
    private static final Logger logger = LogManager.getLogger();
    private static final double EPSILON = 0.001;

    public double triangleSquare(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: triangleSquare({})", customTriangle);
        double a = triangleSides(customTriangle).get("a");
        double b = triangleSides(customTriangle).get("b");
        double c = triangleSides(customTriangle).get("c");
        double square = 0.25 * Math.sqrt((a + b - c) * (a - b + c) * (-a + b + c) * (a + b + c));
        logger.info("square: {}", square);
        //Using Heron's formula
        return square;
    }

    public double trianglePerimeter(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: trianglePerimeter({})", customTriangle);
        double a = triangleSides(customTriangle).get("a");
        double b = triangleSides(customTriangle).get("b");
        double c = triangleSides(customTriangle).get("c");
        double perimeter = a + b + c;
        logger.info("perimeter: {}", perimeter);
        return perimeter;
    }

    public boolean isAcute(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: isAcute({})", customTriangle);
        double abAngle = triangleAngles(customTriangle).get("abAngle");
        double acAngle = triangleAngles(customTriangle).get("acAngle");
        double cbAngle = triangleAngles(customTriangle).get("cbAngle");
        boolean isAcute = abAngle - Math.PI / 2 < -EPSILON
                && acAngle - Math.PI / 2 < -EPSILON
                && cbAngle - Math.PI / 2 < -EPSILON;
        logger.info("isAcute: {}", isAcute);
        return isAcute;
    }

    public boolean isObtuse(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: isObtuse({})", customTriangle);
        double abAngle = triangleAngles(customTriangle).get("abAngle");
        double acAngle = triangleAngles(customTriangle).get("acAngle");
        double cbAngle = triangleAngles(customTriangle).get("cbAngle");
        boolean isObtuse = abAngle - Math.PI / 2 > EPSILON
                || acAngle - Math.PI / 2 > EPSILON
                || cbAngle - Math.PI / 2 > EPSILON;
        logger.info("isObtuse: {}", isObtuse);
        return isObtuse;
    }

    public boolean isRight(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: isRight({})", customTriangle);
        double abAngle = triangleAngles(customTriangle).get("abAngle");
        double acAngle = triangleAngles(customTriangle).get("acAngle");
        double cbAngle = triangleAngles(customTriangle).get("cbAngle");
        boolean isRight = Math.abs(abAngle - Math.PI / 2) < EPSILON
                || Math.abs(acAngle - Math.PI / 2) < EPSILON
                || Math.abs(cbAngle - Math.PI / 2) < EPSILON;
        logger.info("isRight: {}", isRight);
        return isRight;
    }

    public boolean isRegular(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: isRegular({})", customTriangle);
        double a = triangleSides(customTriangle).get("a");
        double b = triangleSides(customTriangle).get("b");
        double c = triangleSides(customTriangle).get("c");
        boolean isRegular = Double.compare(a, b) == 0 && Double.compare(a, c) == 0;
        logger.info("isRegular: {}", isRegular);
        return isRegular;
    }

    public boolean isIsosceles(CustomTriangle customTriangle) {
        logger.info("TriangleCalculationService: isIsosceles({})", customTriangle);
        double a = triangleSides(customTriangle).get("a");
        double b = triangleSides(customTriangle).get("b");
        double c = triangleSides(customTriangle).get("c");
        boolean isIsosceles = Double.compare(a, b) == 0 || Double.compare(a, c) == 0 || Double.compare(b, c) == 0;
        logger.info("isIsosceles: {}", isIsosceles);
        return isIsosceles;
    }

    private Map<String, Double> triangleSides(CustomTriangle customTriangle) {
        CustomPoint vertexOne = customTriangle.getVertexOne();
        CustomPoint vertexTwo = customTriangle.getVertexTwo();
        CustomPoint vertexThree = customTriangle.getVertexThree();
        double x1 = vertexOne.getX();
        double x2 = vertexTwo.getX();
        double x3 = vertexThree.getX();
        double y1 = vertexOne.getY();
        double y2 = vertexTwo.getY();
        double y3 = vertexThree.getY();
        double a = Math.hypot(x1 - x2, y1 - y2);
        double b = Math.hypot(x1 - x3, y1 - y3);
        double c = Math.hypot(x3 - x2, y3 - y2);

        Map<String, Double> sides = new HashMap<>();
        sides.put("a", a);
        sides.put("b", b);
        sides.put("c", c);
        return sides;
    }

    private Map<String, Double> triangleAngles(CustomTriangle customTriangle) {
        double a = triangleSides(customTriangle).get("a");
        double b = triangleSides(customTriangle).get("b");
        double c = triangleSides(customTriangle).get("c");
        //law of cosines
        double abAngle = Math.acos((a * a + b * b - c * c) / (2 * a * b));
        double acAngle = Math.acos((a * a - b * b + c * c) / (2 * a * c));
        double cbAngle = Math.acos((-a * a + b * b + c * c) / (2 * c * b));
        Map<String, Double> angles = new HashMap<>();
        angles.put("abAngle", abAngle);
        angles.put("acAngle", acAngle);
        angles.put("cbAngle", cbAngle);
        return angles;
    }
}
