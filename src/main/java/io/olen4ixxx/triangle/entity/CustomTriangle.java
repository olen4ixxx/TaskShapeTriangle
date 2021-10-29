package io.olen4ixxx.triangle.entity;

import io.olen4ixxx.triangle.observer.CustomObserver;
import io.olen4ixxx.triangle.observer.CustomTriangleEvent;
import io.olen4ixxx.triangle.observer.Observable;
import io.olen4ixxx.triangle.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangle extends CustomShape implements Observable {
    private final int customTriangleId;
    private CustomPoint vertexOne;
    private CustomPoint vertexTwo;
    private CustomPoint vertexThree;
    private final List<CustomObserver> observers = new ArrayList<>();

    CustomTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        vertexOne = new CustomPoint(x1, y1);
        vertexTwo = new CustomPoint(x2, y2);
        vertexThree = new CustomPoint(x3, y3);
        customTriangleId = IdGenerator.generateId();
    }

    CustomTriangle(CustomPoint vertexOne, CustomPoint vertexTwo, CustomPoint vertexThree) {
        customTriangleId = IdGenerator.generateId();
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
    }

    public int getTriangleId() {
        return customTriangleId;
    }

    public CustomPoint getVertexOne() {
        return vertexOne;
    }

    public void setVertexOne(CustomPoint vertexOne) {
        this.vertexOne = vertexOne;
        notifyObservers();
    }

    public CustomPoint getVertexTwo() {
        return vertexTwo;
    }

    public void setVertexTwo(CustomPoint vertexTwo) {
        this.vertexTwo = vertexTwo;
        notifyObservers();
    }

    public CustomPoint getVertexThree() {
        return vertexThree;
    }

    public void setVertexThree(CustomPoint vertexThree) {
        this.vertexThree = vertexThree;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return true;
        }
        CustomTriangle triangle = (CustomTriangle) o;
        return customTriangleId == triangle.customTriangleId
                && vertexOne.equals(triangle.vertexOne)
                && vertexTwo.equals(triangle.vertexTwo)
                && vertexThree.equals(triangle.vertexThree)
                && observers.equals(triangle.observers);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + customTriangleId;
        result = prime * result + vertexOne.hashCode();
        result = prime * result + vertexTwo.hashCode();
        result = prime * result + vertexThree.hashCode();
        result = prime * result + observers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Triangle = {id: %d, %s, %s, %s}", customTriangleId, vertexOne, vertexTwo, vertexThree);
    }

    @Override
    public void attach(CustomObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (observers.isEmpty()) {
            return;
        }
        CustomTriangleEvent event = new CustomTriangleEvent(this);
        observers.forEach(o -> o.parameterChange(event));
    }
}
