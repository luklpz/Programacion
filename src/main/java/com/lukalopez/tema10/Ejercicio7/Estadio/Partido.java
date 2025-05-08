package com.lukalopez.tema10.Ejercicio7.Estadio;

import com.lukalopez.lib.EstructurasDinamicas.Registro;
import com.lukalopez.lib.IO;
import com.lukalopez.tema10.Ejercicio7.*;
import com.lukalopez.tema10.Ejercicio7.Entrada.Entrada;
import com.lukalopez.tema10.Ejercicio7.Entrada.EntradaNormal;
import com.lukalopez.tema10.Ejercicio7.Entrada.EntradaVip;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Partido {
    public enum Afluencia {
        BAJA("baja",0.75f), MEDIA("media",1), ALTA("alta",1.3f);

        private final String nombre;
        private final float modificadorPrecio;

        Afluencia(String nombre, float modificadorPrecio) {
            this.nombre = nombre;
            this.modificadorPrecio = modificadorPrecio;
        }

        public float getModificadorPrecio() {
            return modificadorPrecio;
        }

        public String getNombre() {
            return nombre;
        }
    }

    private float recaudacion;
    public int ultimaIdTicket=0;
    private final Estadio estadio;
    private final Afluencia afluencia;
    private final LocalDateTime fechaHora;
    private final Equipo equipoLocal;
    private final Equipo equipoVisitante;
    private final Registro<Entrada> entradasVendidas;

    //Equipo local y equipo visitante no pueden ser el mismo!!!
    public Partido(Afluencia afluencia, LocalDateTime fechaHora, Equipo equipoLocal, Equipo equipoVisitante) {
        this.estadio = DataGenerator.inicializarEstadio();
        this.afluencia = afluencia;
        this.fechaHora = fechaHora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.recaudacion = 0;
        this.entradasVendidas = new Registro<>();
    }

    public Entrada venderEntrada(){
        Entrada entrada;
        Estadio estadio = this.getEstadio();
        boolean cancelar = false;
        int indexZona = Main.seleccionarZona(this,0)-1;
        int indexFila;
        int indexColumna;
        Asiento asiento;
        Zona zona = estadio.getZonas().get(indexZona);
        boolean pagado;
        float precioFinal;
        do {
            System.out.printf("ZONA Nº%d\nIngrese 0 para cancelar la operación . . .\n",indexZona+1);
            System.out.println(zona.toString(0));
            indexFila = IO.solicitarInt("\nIngrese la fila en la que se encuentra el asiento: ",0,Config.DEFAULT_FILAS)-1;
            if (indexFila==0){
                break;
            }
            indexColumna = IO.solicitarInt("\nIngrese la columna en la que se encunetra el asiento: ",0, Config.DEFAULT_COLUMNAS)-1;

            if (indexColumna==0){
                break;
            }

            //Si el asiento está ocupado
            asiento = zona.obtenerAsiento(indexFila,indexColumna);
            if (asiento.isOcupado()){
                System.out.println("El asiento indicado ya está reservado, selecciona uno diferente. ");
            } else {
                if (zona.isVip()) {
                    entrada =  new EntradaVip(this, indexZona, indexFila, indexColumna);
                } else {
                    entrada =  new EntradaNormal(this, indexZona, indexFila, indexColumna);
                }

                precioFinal = afluencia.modificadorPrecio*zona.getPrecioBase();
                pagado = IO.solicitarBoolean(String.format("El precio de la entrada es: %f\n¿Ha sido pagada? (Si/No)\n ->",precioFinal),"Si","No","Entrada inválida, preube de nuevo.");

                if (pagado) {
                    asiento.setOcupado(true);
                    entradasVendidas.add(entrada);
                    recaudacion+=precioFinal;
                    System.out.println("Entrada vendida.");
                    return entrada;
                } else {
                    System.out.println("La entrada no ha sido pagada.");
                    cancelar=true;
                }
            }
        } while  (!cancelar);
        return null;
    }

    /**
     * Mét0do para hacer la devolución de una entrada.
     * @param id 'id' de la entrada que se desea devolver.
     * @return Devuelve el precio de la entrada que se desea devolver.
     */
    public float devolverEntrada(int id){
        for (Entrada entradasVendida : entradasVendidas) {
            if (entradasVendida.getId() == id) {
                float precio = getAfluencia().getModificadorPrecio() * estadio.getZonas().get(entradasVendida.getIndexZona()).getPrecioBase();
                entradasVendidas.remove(entradasVendida);
                return precio;
            }
        }
        return -1;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public Afluencia getAfluencia() {
        return afluencia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    /**
     * Mét0do para el DataGenerator
     * @param entrada Entrada que se ingresa en la DataBase
     */
    public void anyadirEntrada(Entrada entrada){
        entradasVendidas.add(entrada);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(fechaHora, partido.fechaHora) && Objects.equals(equipoLocal, partido.equipoLocal) && Objects.equals(equipoVisitante, partido.equipoVisitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora, equipoLocal, equipoVisitante);
    }



    /**
     * Este mét0do es un 'toString' con tabulado.
     * @param espaciado Son los espacios en blanco que serán tabulados al inicio de cada línea.
     * @return Devuelve el 'toString' tabulado.
     */
    public String toString(int espaciado){
        StringBuilder espacios = new StringBuilder(espaciado);
        espacios.append(" ".repeat(Math.max(0, espaciado)));

        return espacios + "Afluencia: " + afluencia.toString() + "\n" +
                espacios + "Fecha del partido: " + fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm")) + "\n" +
                espacios + "Equipo local: " + equipoLocal.toString() + "\n" +
                espacios + "Equipo visitante: " + equipoVisitante.toString() + "\n";
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
