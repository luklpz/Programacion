package com.lukalopez.lib.Excepciones;

import java.io.IOException;

public class InvalidEmptyException extends IOException {
    public InvalidEmptyException(String message) {
        super(message);
    }
}
