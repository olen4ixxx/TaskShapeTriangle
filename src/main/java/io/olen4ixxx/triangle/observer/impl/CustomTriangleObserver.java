package io.olen4ixxx.triangle.observer.impl;

import io.olen4ixxx.triangle.entity.CustomTriangle;
import io.olen4ixxx.triangle.observer.CustomTriangleEvent;
import io.olen4ixxx.triangle.observer.CustomObserver;

public class CustomTriangleObserver implements CustomObserver {
    @Override
    public void parameterChange(CustomTriangleEvent event) {
        CustomTriangle customTriangle = event.getSource();
        //get parameters
        //calculate service data
        //get instance warehouse
        //put data by id
    }
}
