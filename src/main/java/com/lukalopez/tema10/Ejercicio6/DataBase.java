package com.lukalopez.tema10.Ejercicio6;

import com.lukalopez.lib.EstructurasDinamicas.Registro;
import com.lukalopez.tema10.Ejercicio6.Personas.Actor;
import com.lukalopez.tema10.Ejercicio6.Personas.Autor;
import com.lukalopez.tema10.Ejercicio6.Personas.Persona;

public class DataBase {
    public enum Formato{
        CD, DVD,BLUERAY, ARCHIVO;
    }

    public enum Plataforma{
        PS5, XBOX, SWITCH;
    }

    public static final Registro<Autor> registroAutores = new Registro<>();
    public static final Registro<Actor> registroActores = new Registro<>();

}
