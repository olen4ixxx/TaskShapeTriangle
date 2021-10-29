package io.olen4ixxx.triangle.filereader.impl;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.filereader.TriangleReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleFileReaderTest {
    TriangleReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new TriangleFileReader();
    }

    @Test(expectedExceptions = CustomTriangleException.class, expectedExceptionsMessageRegExp = "File is not found")
    public void testReadLinesException() throws CustomTriangleException {
        reader.readLines("data/wrongName.txt");
    }

    @Test(timeOut = 100)
    public void testReadLines() throws CustomTriangleException {
        List<String> expected = List.of("tt", "1 t", "0.0 0.0 10.0 0.0 0.0  10.0", "", "1.0 1.0 3.1 1.0 1.0  10.1");
        List<String> actual = reader.readLines("data/triangleTest.txt");
        assertEquals(actual, expected);
    }
}