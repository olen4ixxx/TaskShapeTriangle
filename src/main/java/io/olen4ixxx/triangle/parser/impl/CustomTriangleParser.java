package io.olen4ixxx.triangle.parser.impl;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.parser.CustomParser;
import io.olen4ixxx.triangle.validator.CustomTriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomTriangleParser implements CustomParser {
    private static final Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_TRIANGLE_COORDINATES = 6;

    public List<double[]> parseLinesToTriangleCoordinates(List<String> lines) throws CustomTriangleException {
        logger.info("LinesToCustomTriangleParser: parseLinesToTriangleCoordinates({})", lines);
        CustomTriangleValidator validator = CustomTriangleValidator.getInstance();
        if (validator.isEmptyOrNull(lines)) {
            logger.error("List is empty or null");
            throw new CustomTriangleException("List is empty or null");
        }
        List<Double> coordinatesList = lines.stream()
                .filter(validator::isLineOfCoordinates)
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(validator::isNumeric)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<double[]> listOfTriangleCoordinates = new ArrayList<>();
        for (int i = 0; i < coordinatesList.size(); i += NUMBER_OF_TRIANGLE_COORDINATES) {
            var array = new double[NUMBER_OF_TRIANGLE_COORDINATES];
            for (int j = 0; j < NUMBER_OF_TRIANGLE_COORDINATES; j++) {
                array[j] = coordinatesList.get(i + j);
            }
            listOfTriangleCoordinates.add(array);
        }
        logger.info("listOfTriangleCoordinates: {}", listOfTriangleCoordinates);
        return listOfTriangleCoordinates;
    }
}
