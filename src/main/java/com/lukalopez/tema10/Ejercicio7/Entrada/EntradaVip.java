package com.lukalopez.tema10.Ejercicio7.Entrada;

import com.lukalopez.lib.Random;
import com.lukalopez.tema10.Ejercicio7.Config;
import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;

import java.util.Objects;

public class EntradaVip extends Entrada{
    private static final String BASE_ALFANUMERICA = "0123456789abcdefghijklmnopqrstuvwxyz";

    private final String password;

    public EntradaVip(Partido partido, int indexZona, int indexFila, int indexColumna) {
        super(partido, indexZona, indexFila, indexColumna);
        this.password = generarCodigoAlfanumericoUnico();
    }

    /**
     * Mét0do para generar un código alfanumérico único que sirva como contraseña para la taquilla.
     * @return Devuelve el código alfanumérico asegurando que sus 8 primeros caracteres forman una combinación única.
     */
    public static String generarCodigoAlfanumericoUnico(){
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(System.currentTimeMillis(),36));
        sb.setLength(8);
        for (int i = 0; i < Config.DEFAULT_LONG_CODIGO_ALFANUMERICO-8; i++) {
            sb.append(BASE_ALFANUMERICA.charAt(Random.randomInt(0,BASE_ALFANUMERICA.length()-1)));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntradaVip that = (EntradaVip) o;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password);
    }

    @Override
    public String toString() {
        return "Entrada Nº"+id+
                "\n"+super.toString(2)+
                "\n  Contraseña de la taquilla: "+password;
    }
}
