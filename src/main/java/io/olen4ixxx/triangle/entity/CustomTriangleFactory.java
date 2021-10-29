package io.olen4ixxx.triangle.entity;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.repository.CustomRepository;
import io.olen4ixxx.triangle.service.TriangleCalculation;
import io.olen4ixxx.triangle.service.impl.TriangleCalculationService;
import io.olen4ixxx.triangle.validator.CustomTriangleValidator;
import io.olen4ixxx.triangle.warehouse.CustomWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomTriangleFactory {
    private static final Logger logger = LogManager.getLogger();
    private static CustomTriangleFactory instance;

    public static CustomTriangleFactory getInstance() {
        if (instance == null) {
            instance = new CustomTriangleFactory();
        }
        return instance;
    }

    public CustomTriangle createCustomTriangle(double[] array) throws CustomTriangleException {
        CustomTriangleValidator validator = CustomTriangleValidator.getInstance();
        logger.info("CustomTriangleFactory: createCustomTriangle({})", array);
        if (!(validator.isArrayOfSixCoordinates(array)
                && validator.isTriangle(array[0], array[1], array[2], array[3], array[4], array[5]))) {
            logger.error("Check the array: Points do not define a triangle");
            throw new CustomTriangleException("Check the array: Points do not define a triangle");
        }
        CustomTriangle triangle = new CustomTriangle(array[0], array[1], array[2], array[3], array[4], array[5]);
        addToRepository(triangle);
        addToWarehouse(triangle);
        logger.info("Triangle created: {}", triangle);
        return triangle;
    }

    public CustomTriangle createCustomTriangle(double x1, double y1, double x2, double y2, double x3, double y3)
            throws CustomTriangleException {
        CustomTriangleValidator validator = CustomTriangleValidator.getInstance();
        logger.info("CustomTriangleFactory: createCustomTriangle({}, {}, {}, {}, {}, {})",
                x1, y1, x2, y2, x3, y3);
        if (!(validator.isTriangle(x1, y1, x2, y2, x3, y3))) {
            logger.error("Points do not define a triangle");
            throw new CustomTriangleException("Points do not define a triangle");
        }
        CustomTriangle triangle = new CustomTriangle(x1, y1, x2, y2, x3, y3);
        addToRepository(triangle);
        addToWarehouse(triangle);
        logger.info("Triangle created: {}", triangle);
        return triangle;
    }

    private void addToRepository(CustomTriangle triangle) {
        CustomRepository repository = CustomRepository.getInstance();
        repository.add(triangle);
    }

    private void addToWarehouse(CustomTriangle triangle) {
        CustomWarehouse warehouse = CustomWarehouse.getInstance();
        TriangleCalculation calculation = new TriangleCalculationService();
        double perimeter = calculation.trianglePerimeter(triangle);
        double square = calculation.triangleSquare(triangle);
        warehouse.add(triangle.getTriangleId(), perimeter, square);
    }
}
