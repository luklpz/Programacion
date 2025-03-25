package com.lukalopez.tema07.EjemploClase;

import java.io.IOException;

public class InvalidPlateException extends IOException {
    public InvalidPlateException(String message) {
        super(message);
    }
}
