package io.olen4ixxx.triangle.observer;

public interface Observable {
    void attach(CustomObserver observer);
    void detach(CustomObserver observer);
    void notifyObservers();
}
