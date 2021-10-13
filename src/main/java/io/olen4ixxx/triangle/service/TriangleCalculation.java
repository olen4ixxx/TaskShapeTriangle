package io.olen4ixxx.triangle.service;

import io.olen4ixxx.triangle.entity.CustomTriangle;

public interface TriangleCalculation {
    double triangleSquare(CustomTriangle customTriangle);

    double trianglePerimeter(CustomTriangle customTriangle);

    boolean isAcute(CustomTriangle customTriangle);

    boolean isObtuse(CustomTriangle customTriangle);

    boolean isRight(CustomTriangle customTriangle);

    boolean isRegular(CustomTriangle customTriangle);

    boolean isIsosceles(CustomTriangle customTriangle);
}
