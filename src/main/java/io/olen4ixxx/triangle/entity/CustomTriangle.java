package io.olen4ixxx.triangle.entity;

public class CustomTriangle {
    CustomPoint vertexOne, vertexTwo, vertexThree;

    public CustomTriangle(CustomPoint vertexOne, CustomPoint vertexTwo, CustomPoint vertexThree) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
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
}
