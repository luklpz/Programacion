package com.lukalopez.tema07.EjemploClase;

import java.io.IOException;

public class InvalidPlateNumberException extends IOException {
    public InvalidPlateNumberException(String message) {
        super(message);
    }
}
