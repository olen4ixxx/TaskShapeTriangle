package io.olen4ixxx.triangle.entity;

public class CustomPoint {
    private double x, y;

    public CustomPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint otherPoint = (CustomPoint) o;
        return Double.compare(otherPoint.x, x) == 0 && Double.compare(otherPoint.y, y) == 0;
    }

    @Override
    public String toString() {
        return String.format("Point{%.2f, %.2f}", x, y);
    }
}
