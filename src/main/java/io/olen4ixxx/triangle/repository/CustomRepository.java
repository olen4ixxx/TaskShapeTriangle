package io.olen4ixxx.triangle.repository;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRepository {
    private static final Logger logger = LogManager.getLogger();
    private static CustomRepository instance;
    private final List<CustomTriangle> triangles;

    private CustomRepository() {
        triangles = new ArrayList<>();
    }

    public static CustomRepository getInstance() {
        if (instance == null) {
            instance = new CustomRepository();
        }
        return instance;
    }

    public boolean add(CustomTriangle customTriangle) {
        return triangles.add(customTriangle);
    }

    public boolean remove(int triangleId) {
        for (int i = 0; i < triangles.size(); i++) {
            CustomTriangle triangle = triangles.get(i);
            if (triangle.getTriangleId() == triangleId) {
                logger.info("Triangle removed: {}", triangle);
                return triangles.remove(triangle);
            }
        }
        logger.info("No triangle in repository, id: {}", triangleId);
        return false;
    }

    public boolean addAll(List<CustomTriangle> list) {
        logger.info("Repository addAll: {}", list);
        return triangles.addAll(list);
    }

    public boolean removeAll(List<CustomTriangle> list) {
        logger.info("Repository removeAll: {}", list);
        return triangles.removeAll(list);
    }

    public void clear() {
        triangles.clear();
        logger.info("Repository cleared");
    }

    public List<CustomTriangle> query(CustomSpecification specification) {
        List<CustomTriangle> queryList = triangles.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        logger.info("queryList from repository: {}", queryList);
        return queryList;
    }

    public void sort(Comparator<CustomTriangle> comparator) {
        triangles.sort(comparator);
        logger.info("Repository sorted by {}", comparator);
    }
}
