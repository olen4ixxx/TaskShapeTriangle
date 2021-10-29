package io.olen4ixxx.triangle.filereader.impl;

import io.olen4ixxx.triangle.exception.CustomTriangleException;
import io.olen4ixxx.triangle.filereader.TriangleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleFileReader implements TriangleReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLines(String stringPath) throws CustomTriangleException {
        logger.info("TriangleFileReader: readLines({})", stringPath);
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(stringPath);
        if (resource == null) {
            logger.error("File is not found ({})", stringPath);
            throw new CustomTriangleException("File is not found");
        }
        URI uri;
        try {
            uri = resource.toURI();
        } catch (URISyntaxException e) {
            logger.error("Wrong file path ({})", stringPath);
            throw new CustomTriangleException("Wrong file path", e);
        }
        Path path = Path.of(uri);
        List<String> linesFromFile;
        try (Stream<String> lines = Files.lines(path)) {
            linesFromFile = lines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Check the file ({})", stringPath);
            throw new CustomTriangleException("Check the file", e);
        }
        logger.info("File is read");
        return linesFromFile;
    }
}
