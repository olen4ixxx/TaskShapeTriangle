package io.olen4ixxx.triangle.parser.impl;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.parser.CustomParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEqualsDeep;

public class CustomTriangleParserTest {
    CustomParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new CustomTriangleParser();
    }

    @Test(expectedExceptions = CustomTriangleException.class, expectedExceptionsMessageRegExp = "List is empty or null")
    public void testParseLinesToTriangleCoordinatesExceptionNull() throws CustomTriangleException {
        parser.parseLinesToTriangleCoordinates(null);
    }

    @Test(expectedExceptions = CustomTriangleException.class, expectedExceptionsMessageRegExp = "List is empty or null")
    public void testParseLinesToTriangleCoordinatesExceptionEmpty() throws CustomTriangleException {
        List<String> list = new ArrayList<>();
        parser.parseLinesToTriangleCoordinates(list);
    }

    @Test(timeOut = 100)
    public void testParseLinesToTriangleCoordinates() throws CustomTriangleException {
        double[] array1 = {0.0, 0.0, 10.0, 0.0, 0.0, 10.0};
        double[] array2 = {1.0, 1.0, 3.1, 1.0, 1.0, 10.1};
        Map<Integer, double[]> expected = Map.of(0, array1, 1, array2);

        List<String> linesForParser = List.of("tt", "1 t", "0.0 0.0 10.0 0.0 0.0  10.0",
                "", "1.0 1.0 3.1 1.0 1.0  10.1");
        List<double[]> actualList = parser.parseLinesToTriangleCoordinates(linesForParser);
        Map<Integer, double[]> actual = new HashMap<>();
        for (int i = 0; i < actualList.size(); i++) {
            actual.put(i, actualList.get(i));
        }
        assertEqualsDeep(actual, expected);
    }
}