package io.olen4ixxx.triangle.exception;

public class CustomTriangleException extends Exception {
    public CustomTriangleException(String message) {
        super(message);
    }

    public CustomTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomTriangleException() {
    }

    public CustomTriangleException(Throwable cause) {
        super(cause);
    }
}
