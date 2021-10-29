package io.olen4ixxx.triangle.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdGenerator {
    private static final Logger logger = LogManager.getLogger();
    private static int counter = 0;

    private IdGenerator() {
    }

    public static int generateId() {
        logger.info("Id generated: {}", ++counter);
        return counter;
    }
}
