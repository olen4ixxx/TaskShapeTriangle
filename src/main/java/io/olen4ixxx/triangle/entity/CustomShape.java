package io.olen4ixxx.triangle.entity;

public class CustomShape {
    private double square;
    private double perimeter;

    public CustomShape() {
    }

    public CustomShape(double perimeter, double square) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
