package com.lukalopez.tema10.Ejercicio7;

import com.lukalopez.lib.EstructurasDinamicas.Registro;
import com.lukalopez.lib.Excepciones.RepeatedEntryException;
import com.lukalopez.lib.IO;
import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;

public class DataBase {
    public static Registro<Partido> registroPartidos = new Registro<>();
    public static Registro<Equipo> equipos = new Registro<>();

    /**
     * Met0do para que el usuario seleccione un partido.
     * @param espaciado Es el espaciado que se mostrará al realizar la solicitud.
     * @return Devuelve el partido seleccionado.
     */
    public static Partido seleccionarPartido(int espaciado){
        int entrada;
        Partido partido;

        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, espaciado)));
        String espacios = sb.toString();
        sb.setLength(0);
        sb.append(espacios).append("Seleccione el partido que desea gestionar:\n");
        sb.append(espacios).append("0. Cancelar\n");
        sb.append(espacios).append("---------------------\n");
        sb.append(espacios).append("Partidos:\n");
        for (int i = 0; i < registroPartidos.size(); i++) {
            sb.append(espacios).append("  ").append(i+1).append(". ").append(registroPartidos.get(i).toString()).append("\n");
        }

        entrada = IO.solicitarInt(sb.toString(),1,registroPartidos.size()+1);

        if (entrada==0){
            partido = null;
        } else {
            partido=registroPartidos.get(entrada-1);
        }
        return partido;
    }

    /**
     * Met0do para que el usuario seleccione o cree un equipo del registro.
     * @param espaciado Es el espaciado que se mostrará al realizar la solicitud.
     * @return Devuelve el equipo seleccionado o creado.
     */
    public static Equipo seleccionarEquipo(int espaciado){
        Equipo equipo = null;
        boolean valido=false;
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, espaciado)));
        String espacios = sb.toString();
        sb.setLength(0);

        sb.append(espacios).append("0. Crear nuevo equipo\n");
        sb.append(espacios).append("---------------------\n");
        sb.append(espacios).append("Equipos:\n");
        for (int i = 0; i < equipos.size(); i++) {
            sb.append(espacios).append("  ").append(i+1).append(". ").append(equipos.get(i).toString()).append("\n");
        }
        do {
            int entrada = IO.solicitarInt(sb.toString(), 0, equipos.size());
            if (entrada == 0) {
                try {
                    equipo = new Equipo(IO.solicitarString("\n" + espacios + "Ingrese el nombre del equipo: "));
                    equipos.add(equipo);
                    valido = true;
                } catch (RepeatedEntryException ree) {
                    System.out.println("Ya existe un equipo como el que se ha introducido.");
                }
            } else {
                equipo = equipos.get(entrada-1);
                valido = true;
            }
        } while (!valido);
        return equipo;
    }
}
