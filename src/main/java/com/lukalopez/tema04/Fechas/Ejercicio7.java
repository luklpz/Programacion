package com.lukalopez.tema04.Fechas;

import com.lukalopez.lib.Escaner;
import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

import java.time.LocalDate;

public class Ejercicio7 {
    /**
     * Imprime el menú principal y devuelve la opción seleccionada por el usuario.
     *
     * @param mensaje Mensaje opcional que se desea imprimir previamente al menú.
     * @param fecha Fecha que se desea imprimir en el menú.
     * @return Devuelve la opción del menú deseada por el usuario.
     */
    private static int llamarMenuPrincipal(String mensaje, LocalDate fecha){
        int opcion = 4;
        String fechaFormateada = FH.formatearFecha(fecha,"dd/MM/yyyy");
        System.out.print(mensaje);
        System.out.printf("\n*********************************\n** FECHA CALCULADA: %s **\n*********************************\n1. Modificar fecha calculada\n2. Operaciones ...\n------------------------------------------\n0. Salir del programa\n", fechaFormateada);
        do {
            opcion = Integer.parseInt(Escaner.lector.nextLine());
            if (opcion<0||opcion>3) {
                System.out.print("\n\u001B[0;31mOpción \u001B[1minválida\u001B[0m, intentelo de nuevo.\n");
            }
        }while (opcion<0||opcion>3);
        return opcion;
    }

    /**
     * Imprime el menú de operaciones y devuelve la opción seleccionada por el usuario.
     *
     * @param mensaje Mensaje opcional que se desea imprimir previamente al menú.
     * @param fecha Fecha que se desea imprimir en el menú.
     * @return Devuelve la opción del menú deseada por el usuario.
     */
    private static int llamarMenuOperaciones(String mensaje, LocalDate fecha){
        int opcion = 7;
        String fechaFormateada = FH.formatearFecha(fecha,"dd/MM/yyyy");
        System.out.print(mensaje);
        System.out.printf("\n*********************************\n***        OPERACIONES        ***\n** FECHA CALCULADA: %s **\n*********************************\n1. Sumar años\n2. Sumar meses\n3. Sumar días\n4. Restar años\n5. Restar meses\n6. Restar días\n-----------------------\n0. Volver al menú principal\n", fechaFormateada);
        do {
            opcion = Integer.parseInt(Escaner.lector.nextLine());
            if (opcion<0||opcion>3) {
                System.out.print("\n\u001B[0;31mOpción \u001B[1minválida\u001B[0m, intentelo de nuevo.\n");
            }
        }while (opcion<0||opcion>6);
        return opcion;

    }

    /**
     * Devuelve la fecha una vez realizada la operación deseada.
     *
     * @param operacion Operación que se desea realizar.
     * @param fecha Fecha sobre la cual se desea trabajar.
     * @return Devuelve la fecha modificada.
     */
    private static LocalDate ejecutarMenuOpciones(int operacion, LocalDate fecha){
        int modificador=0;
        switch (operacion){
            case 1-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de años a sumar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.plusYears(modificador);
            }
            case 2-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de meses a sumar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.plusMonths(modificador);
            }
            case 3-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de dias a sumar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.plusDays(modificador);
            }
            case 4-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de años a restar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.minusYears(modificador);
            }
            case 5-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de meses a restar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.minusMonths(modificador);
            }
            case 6-> {
                do {
                    modificador = IO.solicitarInt("Introduce la candidad de dias a restar:", 1, 9999,"Error");
                } while (modificador < 1 || modificador > 9999);
                fecha = fecha.minusDays(modificador);
            }
            default-> {}
        }
        return fecha;
    }

    public static void main(String args[]){
        LocalDate fecha = LocalDate.now();
        LocalDate fechaModificada;
        boolean cerrar=false;
        int seleccion, operacion;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            seleccion = llamarMenuPrincipal("", fecha);
            switch (seleccion){
                case 1-> {
                    fecha = FH.solicitarFecha("Establece la fecha a partir de la cual se realizarán los cálculos:");
                }
                case 2-> {
                    fechaModificada = fecha;
                    do {
                        fecha = fechaModificada;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        operacion = llamarMenuOperaciones("", fecha);
                        fechaModificada = ejecutarMenuOpciones(operacion, fecha);
                    } while (!fecha.isEqual(fechaModificada));
                }
                case 0-> {}
                default-> System.out.println("\n\u001B[1;31mERROR: \u001B[0;31mEntrada inesperada.\u001B[0m");
            }
        }while (seleccion!=0);
    }
}
