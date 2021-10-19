package io.olen4ixxx.triangle.entity;

import io.olen4ixxx.triangle.observer.CustomTriangleEvent;
import io.olen4ixxx.triangle.observer.Observable;
import io.olen4ixxx.triangle.observer.CustomObserver;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangle extends CustomShape implements Observable {
    private CustomPoint vertexOne;
    private CustomPoint vertexTwo;
    private CustomPoint vertexThree;
    private int triangleId;
    private List<CustomObserver> observers = new ArrayList<>();

    public CustomTriangle(CustomPoint vertexOne, CustomPoint vertexTwo, CustomPoint vertexThree) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
    }

    public int getTriangleId() {
        return triangleId;
    }

    public CustomPoint getVertexOne() {
        return vertexOne;
    }

    public void setVertexOne(CustomPoint vertexOne) {
        this.vertexOne = vertexOne;
    }

    public CustomPoint getVertexTwo() {
        return vertexTwo;
    }

    public void setVertexTwo(CustomPoint vertexTwo) {
        this.vertexTwo = vertexTwo;
    }

    public CustomPoint getVertexThree() {
        return vertexThree;
    }

    public void setVertexThree(CustomPoint vertexThree) {
        this.vertexThree = vertexThree;
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
        CustomTriangleEvent event = new CustomTriangleEvent(this);
        observers.forEach(o -> o.parameterChange(event));
    }
}
