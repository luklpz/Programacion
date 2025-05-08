package com.lukalopez.tema10.Ejercicio7;

import com.lukalopez.lib.Excepciones.RepeatedEntryException;
import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;
import com.lukalopez.tema10.Ejercicio7.Entrada.Entrada;
import com.lukalopez.tema10.Ejercicio7.Estadio.Partido;
import com.lukalopez.tema10.Ejercicio7.Estadio.Zona;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DataGenerator.anyadirDatosIniciales();
        ejecutarMenuInicio();
    }

    private static String menuInicio(){
        return """
                *--*---*--*---*--*---*--*
                |     MENU  ESTADIO     |
                *--*---*--*---*--*---*--*
                |   1. Nuevo partido    |
                |   2. Gestion entradas |
                |-----------------------|
                |   0. Salir            |
                *--*---*--*---*--*---*--*
                """;
    }

    private static void ejecutarMenuInicio(){
        boolean salir=false;
        do {
            int entrada = IO.solicitarInt(menuInicio(), 0, 2);
            switch (entrada) {
                case 1 -> nuevoPartido();
                case 2 -> ejecutarMenuGestionEntradas();
                default -> salir=true;
            }
        } while (!salir);
    }

    private static String menuGestionEntradas(Partido partido){
        int contador = partido.getEquipoLocal().toString().length()+partido.getEquipoVisitante().toString().length()+4;
        String espaciado1 = " ".repeat(Math.max(0, (39-contador)/2));
        String espaciado2;
        if (espaciado1.length() % 2 == 0){
            espaciado2 = espaciado1;
        } else {
            espaciado2 = espaciado1+" ";
        }
        return """
                |=======================================|
                """ +
                "|" + espaciado1 +partido.getEquipoLocal().getNombre() +" vs " + partido.getEquipoVisitante().getNombre() + espaciado2 + "|\n" +
                """
                |---------------------------------------|
                |   1. Venta de entradas                |
                |   2. Devolver entrada                 |
                |   3. Estado de los asientos           |
                |   4. Mostrar recaudación del partido  |
                |---------------------------------------|
                |   0. Volver al menú principal         |
                |=======================================|
                """;
    }

    private static void ejecutarMenuGestionEntradas(){
        boolean salir =false;
        Partido partido = DataBase.seleccionarPartido(0);
        do {
            int entrada = IO.solicitarInt(menuGestionEntradas(partido),0,4);
            switch (entrada) {
                case 1 -> {
                    Entrada entradaVendida= partido.venderEntrada();
                    if (entradaVendida==null){
                        System.out.println("Operación cancelada.");
                    } else {
                        System.out.println(entradaVendida.toString(0));
                    }
                }
                case 2 -> {
                    String mensaje;
                    float cantidadDevolucion;
                    entrada = IO.solicitarInt("Ingresa el id numérico de tu ticket: ",1, IO.Condicion.MINIMO);
                    cantidadDevolucion = partido.devolverEntrada(entrada);
                    if (cantidadDevolucion==-1){
                        mensaje = "No existe un ticket con el id proporcionado para este partido.";
                    } else {
                        mensaje = String.format("Se ha retirado el ticket satisfactoriamente.\nImporte a devolver: %f", cantidadDevolucion);
                    }
                    System.out.println(mensaje);
                }
                case 3 -> System.out.println(partido.getEstadio().toString(0));
                case 4 -> System.out.println("El partido: " + partido.toString(12) + "\nHa recaudado " + partido.getRecaudacion() + "\n");

                default -> salir=true;
            }
        } while (!salir);
    }

    private static String menuAfluencia(){
        return """
                \n¿Cual es la afluencia del partido?
                |-----------------------|
                |   1. Baja afluencia   |
                |   2. Media afluencia  |
                |   3. Alta afluencia   |
                |-----------------------|
                """;
    }


    private static void nuevoPartido(){
        Partido partido;

        LocalDateTime fechaHora = FH.solicitarFechaHora("A continuación ingrese la fecha y la hora a la que se celebrará el partido (dd/mm/yyyy hh:mm): \n", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        Partido.Afluencia afluencia = Partido.Afluencia.values()[IO.solicitarInt(menuAfluencia(),1,3)-1];

        System.out.println("\nSeleccione al equipo local:");
        Equipo local = DataBase.seleccionarEquipo(0);


        Equipo visitante;
        boolean valido=false;
        do {
            System.out.println("\nSeleccione al equipo visitante:");
            visitante = DataBase.seleccionarEquipo(0);
            if (visitante.equals(local)){
                System.out.println("El equipo visitante no puede ser el mismo que el equipo local, seleccione uno distinto.\n");
            } else {
                valido=true;
            }
        } while (!valido);

        try {
            partido = new Partido(afluencia, fechaHora, local, visitante);
            DataBase.registroPartidos.add(partido);
            System.out.println("El partido ha sido creado con éxito.");
        } catch (RepeatedEntryException ree) {
            System.out.println("Ya existe un equipo como el que se ha introducido, por lo que el partido no ha sido creado.");
        }
    }

    public static int seleccionarZona(Partido partido, int espaciado){
        StringBuilder sb = new StringBuilder(espaciado);
        sb.append(" ".repeat(Math.max(0, espaciado)));

        String espacios = sb.toString();
        sb.setLength(0);
        Zona zona;
        for (int i = 0; i < partido.getEstadio().getZonas().size(); i++) {
            zona = partido.getEstadio().getZonas().get(i);
            sb.append(espacios).append("\u001B[0;36mZONA Nº").append(i+1).append("\u001B[0m");
            if (zona.isVip()){
                sb.append(" - \u001B[0;33mVIP\u001B[0m\n");
            } else {
                sb.append(" - \u001B[0;32mNORMAL\u001B[0m\n");
            }
            sb.append(espacios).append("  Precio de la entrada: \u001B[0:33m").append(zona.getPrecioBase()*partido.getAfluencia().getModificadorPrecio()).append("\u001B[0m\n");
            sb.append(espacios).append("  Asientos disponibles: ").append(zona.asientosDisponibles()).append("\n");
        }
        return IO.solicitarInt(sb.toString(),1,partido.getEstadio().getZonas().size());
    }
}
