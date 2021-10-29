package io.olen4ixxx.triangle.repository;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.entity.CustomTriangleFactory;
import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.repository.impl.AllPointsInFirstQuadrantSpecification;
import io.olen4ixxx.triangle.repository.impl.IsInRadiusOfOSpecification;
import io.olen4ixxx.triangle.repository.impl.PerimeterIsBetweenSpecification;
import io.olen4ixxx.triangle.repository.impl.SquareIsBetweenSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomRepositoryTest {
    CustomTriangleFactory factory;
    CustomRepository repository;
    CustomTriangle triangle0;
    CustomTriangle triangle1;
    CustomTriangle triangle2;
    CustomTriangle triangle3;
    CustomSpecification specification;

    @BeforeMethod
    public void setUp() throws CustomTriangleException {
        repository = CustomRepository.getInstance();
        factory = CustomTriangleFactory.getInstance();
        triangle0 = factory.createCustomTriangle(2, 2, 3, 4, -5, -6);
        triangle1 = factory.createCustomTriangle(4, 2, 3, 4, -5, 6);
        triangle2 = factory.createCustomTriangle(3, 2, 3, 4, 5, -6);
        triangle3 = factory.createCustomTriangle(1, 2, 3, 4, 0.5, 0.6);
    }

    @AfterMethod
    public void tearDown() {
        repository.clear();
    }

    @Test(timeOut = 1000)
    public void testQueryFirstQuadrant() {
        CustomTriangle expected = triangle3;
        specification = new AllPointsInFirstQuadrantSpecification();
        CustomTriangle actual = repository.query(specification).get(0);
        assertEquals(actual, expected);
    }

    @Test(timeOut = 1000)
    public void testQueryInRadiusOfO() {
        CustomTriangle expected = triangle3;
        specification = new IsInRadiusOfOSpecification(6);
        CustomTriangle actual = repository.query(specification).get(0);
        assertEquals(actual, expected);
    }

    @Test(timeOut = 1000)
    public void testQueryPerimeterIsBetween() {
        CustomTriangle expected = triangle3;
        specification = new PerimeterIsBetweenSpecification(8, 9);
        CustomTriangle actual = repository.query(specification).get(0);
        assertEquals(actual, expected);
    }

    @Test(timeOut = 1000)
    public void testQuerySquareIsBetween() {
        CustomTriangle expected = triangle3;
        specification = new SquareIsBetweenSpecification(0.9, 0.91);
        CustomTriangle actual = repository.query(specification).get(0);
        assertEquals(actual, expected);
    }
}