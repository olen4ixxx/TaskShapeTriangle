package io.olen4ixxx.triangle.warehouse;

import io.olen4ixxx.triangle.entity.CustomShape;

import java.util.HashMap;
import java.util.Map;

public class CustomWarehouse {
    private static CustomWarehouse instance;
    private final Map<Integer, CustomShape> parameters;

    private CustomWarehouse() {
        parameters = new HashMap<>();
    }

    public static CustomWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomWarehouse();
        }
        return instance;
    }

    public boolean updateParameters(int shapeId, double perimeter, double square) {
        CustomShape shape = parameters.get(shapeId);
        if (shape == null) {
            return false;
        }
        shape.setPerimeter(perimeter);
        shape.setSquare(square);
        return true;
    }

    public void add(int shapeId, CustomShape shape) {
        parameters.put(shapeId, shape);
    }

    public void add(int shapeId, double perimeter, double square) {
        parameters.put(shapeId, new CustomShape(perimeter, square));
    }

    public void remove(int shapeId) {
        parameters.remove(shapeId);
    }

    public boolean contains(int shapeId) {
        return parameters.containsKey(shapeId);
    }

    public boolean contains(double perimeter, double square) {
        return parameters.containsValue(new CustomShape(perimeter, square));
    }
}