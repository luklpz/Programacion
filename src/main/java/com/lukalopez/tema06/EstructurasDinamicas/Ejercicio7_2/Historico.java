package com.lukalopez.tema06.EstructurasDinamicas.Ejercicio7_2;

import com.lukalopez.lib.FH;
import com.lukalopez.lib.IO;

public class Historico {

    enum MotivoDeAlta{
        MEJORA, DEFUNCION, TRATAMIENTO, DERIVACION_HOSPITAL, ERROR
    }

    /**
     * Contenido del array 'data':
     * 0 -> Paciente
     * 1 -> Fecha de entrada
     * 2 -> Hora de entrada
     * 3 -> Sintomatologia
     * 4 -> Array de datos
     * 5 -> Fecha de alta
     * 6 -> Hora de alta
     * 7 -> Motivo del alta
     */
    private Object[][] data;
    private int size;
    private final static int CAPACIDAD_INICIAL = 30;
    private final static float FACTOR_DE_CRECIMIENTO = 2f;

    public Historico(final int CAPACIDAD) {
        this.data = new Object[CAPACIDAD][6];
        this.size = 0;
    }

    public Historico(){
        Historico historico = new Historico(CAPACIDAD_INICIAL);
    }


    /*******************************************METODOS PRINCIPALES*******************************************/


    public boolean atenderPaciente(final int sip){
        Paciente paciente = Main.buscarPorSip(sip);

        if (paciente.getNombre().equals(null)){
            System.err.printf("ERROR: El paciente con sip \'%d\' todavía no existe.\n",sip);
            return false;
        } else {
            final int INDICE_PACIENTE = buscarPorSip(sip);
            switch (INDICE_PACIENTE){
                case -1,-2 -> crearRegistro(paciente);
                default -> {
                    if (data[INDICE_PACIENTE][3]==null){
                        //Tomar datos
                        tomarDatos(INDICE_PACIENTE);
                    } else {
                        //Dar el alta
                        System.err.println("ERROR: Hay que dar de alta al paciente.");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean crearRegistro(Paciente paciente){
        if (isFull()){
            expand();
        }

        System.out.println("Creando registro para el paciente . . .");
        data[size][0] = paciente;
        data[size][1] = FH.solicitarFecha("Ingrese la fecha de entrada (dd/mm/yyyy): ","dd/MM/yyyy");
        data[size][2] = FH.solicitarHora("\nIngrese la hora de entrada (hh:mm:ss): ","HH:mm:ss");
        data[size][3] = IO.solicitarString("\nIntroduzca la sintomatología:",false);

        size++;
        return true;
    }

    private boolean tomarDatos(int indice){
        double[] datos= new double[4];
        //Solicitamos la temperatura
        datos[0] = IO.solicitarDouble("Introduzca la temperatura: ",34,42,"ERROR: La entrada introducida no es válida (34-42).\n");

        //Solicitamos las pulsaciones por minuto
        datos[1] = IO.solicitarDouble("Introduzca las pulsaciones por minuto: ",40,130,"ERROR: La entrada introducida no es válida (40-130).\n");

        //Solicitamos los dos valores de la tension arterial
        datos[2] = IO.solicitarDouble("Introduzca la presión sistólica: ",80,200,"ERROR: La entrada introducida no es válida (80-200).\n");;
        datos[3] = IO.solicitarDouble("Introduzca la temperatura del paciente: ",45,120,"ERROR: La entrada introducida no es válida (45-120).\n");
        data[indice][4] = datos;
        return true;
    }

    public boolean darDeAlta(){
        int sip = Main.solicitarSip();
        final int INDICE_PACIENTE = buscarPorSip(sip);

        if (INDICE_PACIENTE<0){
            System.err.printf("ERROR: No existe registro para el SIP %d.\n",sip);
            return false;
        } else if(data[INDICE_PACIENTE][3]==null){
            System.err.println("ERROR: No se han tomado aún los datos del paciente.\n");
            return false;
        }
        data[size][5] = FH.solicitarFecha("Ingrese la fecha de alta (dd/mm/yyyy): ","dd/MM/yyyy");
        data[size][6] = FH.solicitarHora("\nIngrese la hora de alta (hh:mm:ss): ","HH:mm:ss");

        //Solicitamos el motivo del alta
        int motivoAlta = IO.solicitarInt("Ingrese el motivo del alta:\n   1. Tratamiento\n   2. Mejora\n   3. Derivación hospital\n   4. Defunción\n",1,4,"ERROR: Se ha introducudo una entrada invalida.\n");

        MotivoDeAlta motivo;
        switch (motivoAlta){
            case 1 -> motivo = MotivoDeAlta.TRATAMIENTO;
            case 2 -> motivo = MotivoDeAlta.MEJORA;
            case 3 -> motivo = MotivoDeAlta.DERIVACION_HOSPITAL;
            case 4 -> motivo = MotivoDeAlta.DEFUNCION;
            default -> motivo = MotivoDeAlta.ERROR;
        }
        data[size][7] = motivo;
        return true;
    }

    /*******************************************METODOS AUXILIARES*******************************************/

    private int buscarPorSip(final int SIP_REQUERIDO){
        //Comprobamos si el historial está vacío
        if (isEmpty()){
            return -1;
        }

        Paciente aux;
        //Recorremos el array de pacientes en busca de uno que tenga el sip requerido
        for (int i = 0; i < size; i++) {
            aux = getPersona(i);
            if (aux.getSip()==SIP_REQUERIDO&&data[i][7]==null){
                return i;
            }
        }
        return -2;
    }

    private Paciente getPersona(int index){

        //Validamos que el dato que estamos extrayendo sea una persona.
        Object obj = data[index][0];
        if (!(obj instanceof Paciente)) {
            System.err.println("ERROR: El dato extraido no es un paciente.");
            return null;
        }

        return (Paciente) data[index][0];
    }




    /*******************************************METODOS DEL ARRAY*******************************************/

    /**
     * Comprobación de si el registro no tiene datos.
     * @return Devuelve 'true' si el registro se encuentra vacío.
     */
    private boolean isEmpty(){
        return size == 0;
    }

    /**
     * Mét0do para ampliar la capacidad del array según el factor de crecimiento
     */
    private void expand() {
        Object[][] aux = new Object[Math.round(data.length * FACTOR_DE_CRECIMIENTO)][data[0].length];
        if (size >= 0) System.arraycopy(data, 0, aux, 0, size);
        data = aux;
    }

    /**
     * Obtiene el elemento que ocupa el índice index
     * @param index Índice del elemento a obtener
     * @return el valor obtenido o null
     */
    private Object get(int index) {
        if (index >= size || index < 0)
            return null;
        return data[index];
    }

    private boolean isFull() {
        return size == data.length;
    }
}
