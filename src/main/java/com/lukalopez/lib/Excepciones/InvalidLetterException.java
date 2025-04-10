package com.lukalopez.lib.Excepciones;

import java.io.IOException;

public class InvalidLetterException extends IOException {
    public InvalidLetterException(String message) {
        super(message);
    }
}
