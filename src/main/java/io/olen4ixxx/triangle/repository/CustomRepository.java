package io.olen4ixxx.triangle.repository;

import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRepository {
    private List<CustomTriangle> triangles;

    public boolean add(CustomTriangle customTriangle) {
        return triangles.add(customTriangle);
    }

    public boolean remove(int id) {
        for (int i = 0; i < triangles.size(); i++) {
            var triangle = triangles.get(i);
            if (triangle.getTriangleId() == id) {
                return triangles.remove(triangle);
            }
        }
        return false;
    }

    public boolean addAll(Collection<CustomTriangle> c) {
        return triangles.addAll(c);
    }

    public boolean removeAll(Collection<CustomTriangle> c) {
        return triangles.removeAll(c);
    }

    public void clear() {
        triangles.clear();
    }

    public List<CustomTriangle> query(CustomSpecification specification) {
        return triangles.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
