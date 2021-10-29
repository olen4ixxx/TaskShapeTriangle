package io.olen4ixxx.triangle.service.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.entity.CustomTriangleFactory;
import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TriangleCalculationServiceTest {
    CustomTriangleFactory factory;
    TriangleCalculation calculation;
    CustomTriangle triangleRightIsosceles;
    CustomTriangle triangleAcuteRegular;
    CustomTriangle triangleObtuse;
    double delta;

    @BeforeMethod
    public void setUp() throws CustomTriangleException {
        calculation = new TriangleCalculationService();
        factory = CustomTriangleFactory.getInstance();
        triangleRightIsosceles = factory.createCustomTriangle(0, -10, -10, 0, 0, 0);
        triangleAcuteRegular = factory.createCustomTriangle(5, 5 * Math.sqrt(3), 10, 0, 0, 0);
        triangleObtuse = factory.createCustomTriangle(0, 10, 10, 0, 1, 0);
        delta = 0.001;
    }

    @Test(timeOut = 100)
    public void testTriangleSquare() {
        double expected = 10 * 10 * 0.5;
        double actual = calculation.triangleSquare(triangleRightIsosceles);
        assertEquals(actual, expected, delta);
    }

    @Test(timeOut = 100)
    public void testTrianglePerimeter() {
        double expected = 10 + 10 + Math.hypot(10, 10);
        double actual = calculation.trianglePerimeter(triangleRightIsosceles);
        assertEquals(actual, expected, delta);
    }

    @Test(timeOut = 100)
    public void testIsAcute() {
        assertTrue(calculation.isAcute(triangleAcuteRegular));
    }

    @Test(timeOut = 100)
    public void testIsObtuse() {
        assertTrue(calculation.isObtuse(triangleObtuse));
    }

    @Test(timeOut = 100)
    public void testIsRight() {
        assertTrue(calculation.isRight(triangleRightIsosceles));
    }

    @Test(timeOut = 100)
    public void testIsRegular() {
        assertTrue(calculation.isRegular(triangleAcuteRegular));
    }

    @Test(timeOut = 100)
    public void testIsIsosceles() {
        assertTrue(calculation.isIsosceles(triangleAcuteRegular));
    }
}