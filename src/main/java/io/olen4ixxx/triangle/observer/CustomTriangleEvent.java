package io.olen4ixxx.triangle.observer;

import io.olen4ixxx.triangle.entity.CustomTriangle;

import java.util.EventObject;

public class CustomTriangleEvent extends EventObject {

    public CustomTriangleEvent(CustomTriangle source) {
        super(source);
    }

    @Override
    public CustomTriangle getSource() {
        return (CustomTriangle) super.getSource();
    }
}
