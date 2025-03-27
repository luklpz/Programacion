package com.lukalopez.lib.Excepciones;

import java.io.IOException;

public class InvalidLimitsException extends IOException {
    public InvalidLimitsException(String message) {
        super(message);
    }
}
