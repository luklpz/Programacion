package com.lukalopez.tema07.EjemploClase;

import javax.naming.InvalidNameException;

public class InvalidPlateLettersException extends InvalidNameException {
    public InvalidPlateLettersException(String message) {
        super(message);
    }
}
