package io.olen4ixxx.triangle.entity;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEqualsDeep;

public class CustomTriangleFactoryTest {
    CustomTriangleFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = CustomTriangleFactory.getInstance();
    }

    @Test(expectedExceptions = CustomTriangleException.class)
    public void testCreateCustomTriangleExceptionNotOfSixCoordinatesArray() throws CustomTriangleException {
        double[] array = {1, 2, 3, 4, 5};
        factory.createCustomTriangle(array);
    }

    @Test(expectedExceptions = CustomTriangleException.class)
    public void testCreateCustomTriangleExceptionNotTriangle() throws CustomTriangleException {
        double[] array = {1, 2, 2, 4, 3, 6};
        factory.createCustomTriangle(array);
    }

    @Test(timeOut = 1000)
    public void testCreateCustomTriangle() throws CustomTriangleException {
        CustomTriangle expectedTriangle = new CustomTriangle(-1, 2, 2, 4, 3, 6);
        Map<Integer, CustomPoint> expected = Map.of(0, expectedTriangle.getVertexOne(),
                1, expectedTriangle.getVertexTwo(), 2, expectedTriangle.getVertexThree());
        double[] array = {-1, 2, 2, 4, 3, 6};
        CustomTriangle actualTriangle = factory.createCustomTriangle(array);
        Map<Integer, CustomPoint> actual = Map.of(0, actualTriangle.getVertexOne(),
                1, actualTriangle.getVertexTwo(), 2, actualTriangle.getVertexThree());
        assertEqualsDeep(actual, expected);
    }
}