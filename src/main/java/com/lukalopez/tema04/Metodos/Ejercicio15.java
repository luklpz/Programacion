package com.lukalopez.tema04.Metodos;

import com.lukalopez.lib.Calc;

import java.util.Scanner;

public class Ejercicio15 {

    //Abrir escaner
    private static Scanner lector = new Scanner(System.in);
    //Cerrar escaner
    private static void dispose(){
        lector.close();
    }

    //MENSAJES
    /**
     * Métod0 que devuelve el título
     * @return Devuelve 'String titulo'
     */
    private static String msgTitulo(){
        String titulo = "\n                                               *===========*\n                                                 D A D O S\n                                               *===========*";
        return titulo;
    }

    /**
     * Métod0 que devuelve la pregunta de si quiere plantarse
     * @return Devuelve 'String plantarse'
     */
    private static String msgPlantarse(){
        String plantarse = "                                         ¿Quieres plantarte? (\u001b[1;32mSi\u001b[0m/\u001b[1;31mNo\u001b[0m)\n";
        return plantarse;
    }

    /**
     *Métod0 que devuelve el contador
     * @return Devuelve 'String contador'
     */
    private static String msgContador(){
        String contador = "\n                                             >---------------<\n                                               R O N D A   %d\n                                             >---------------<\n\n\n";
        return contador;
    }

    /**
     * Métod0 que devuelve el mensaje de tirar un dado por primera vez
     * @return Devuelve 'String tirarDado'
     */
    private static String msgTirarDado(){
        String tirarDado ="                                       Para comenzar  tirarás un dado\n                                        \u001b[1;31mP\u001b[32mu\u001b[33ml\u001b[34ms\u001b[35me \u001b[36m'\u001b[37mE\u001b[38mN\u001b[31mT\u001b[32mE\u001b[33mR\u001b[34m' \u001b[35mp\u001b[36ma\u001b[37mr\u001b[38ma \u001b[31mc\u001b[32mo\u001b[33mn\u001b[34mt\u001b[35mi\u001b[36mn\u001b[37mu\u001b[38ma\u001b[31mr\u001b[0m";
        return tirarDado;
    }

    /**
     * 'String' que contiene las reglas del juego.
     * @return Devuelve un 'String' que contiene las relgas del juego
     */
    private static String msgReglas(){
        String reglas = ("\n\n\n\u001b[1m|************************************************ REGLAS ************************************************|\u001b[0m\n\u001b[1m|   \u001b[0mSe dispone de un dado normal de 6 caras con valores comprendidos entre el 1 y 6. El objetivo del     |\n\u001b[1m|   \u001b[0mjuego es sumar más puntos que \u001b[1;35mel rival\u001b[0m sin pasasrse de 11 puntos. Empezarás \u001b[1;33mtú\u001b[0m, que lanzarás         |\n\u001b[1m|   \u001b[0mlos dados hasta que ocurra alguno de los siguientes acontecimientos:                                 |\n\u001b[1m|   \u001b[0m a) Obtengas exactamente 11 puntos.                                                                  |\n\u001b[1m|   \u001b[0m     - Sumarás dos porras (1 por ganar y otra como bonificación por alcanzar la puntuación máxima.   |\n\u001b[1m|   \u001b[0m b) Decidas plantarte con una puntuación inferior a 11.                                              |\n\u001b[1m|   \u001b[0m     - \u001b[1;35mEl rival\u001b[0m jugará e intentará igualarte o superarte sin pasarse de 11 puntos.                   |\n\u001b[1m|   \u001b[0m       Si lo consigue sumará porra, si además consigue 11 puntos sumará una porra extra.             |\n\u001b[1m|   \u001b[0m c) Te pases de los 11 puntos.                                                                       |\n\u001b[1m|   \u001b[0m     - En este caso perderás y \u001b[1;35mtu rival\u001b[0m sumará automáticamente una porra sin jugar.                  |\n\u001b[1m|   \u001b[1;36mEl primero que sume 5 porras gana la partida.\u001b[0m                                                        |\n\u001b[1m|********************************************************************************************************|\u001b[0m\n\n\n");
        return reglas;
    }

    /**
     * Métod0 que devuelve el mensaje de victoria
     * @return Devuelve 'String victoria'
     */
    private static String msgVictoria(){
        String victoria = "\n                                               \u001b[1;32m*===============*\n                                                V I C T O R I A\n                                               *===============*\u001b[0m\n\n                        \u001b[33mHas conseguido 5 o más porras, por lo que has ganado la partida.\u001b[0m\n\n\n";
        return victoria;
    }

    /**
     * Métod0 que devuelve el mensaje de derrota
     * @return Devuelve 'String derrota'
     */
    private static String msgDerrota(){
        String derrota = "\n                                              \u001b[1;31m*=============*\n                                               D E R R O T A\n                                              *=============*\u001b[0m\n\n                 \u001b[35mTu rival \u001b[33mha conseguido 5 o más porras, por lo que has perdido la partida.\u001b[0m\n\n\n";
        return derrota;
    }




    /**
     * Tira un dado de seis caras.
     *
     * @return Devuelve un 'int' aleatorio del 1 al 6.
     * @author luklpz
     */
    private static int tirarDado(){
        return Calc.randomInt(1,6);
    }

    /**
     * Pregunta si el usuario desea plantarse o tirar otro dado.
     *
     * @return Devuelve 'true' si el usuario decide plantarse y 'false' si el usuario decide tirar otro dado
     * @author luklpz
     */
    private static boolean plantarse(){
        boolean plantarse, valido;
        valido=false;
        plantarse=false;
        do {
            System.out.print(msgPlantarse());
            String respuesta;
            respuesta= lector.nextLine();
            if (respuesta.equals("Si")||respuesta.equals("SI")||respuesta.equals("si")) {
                plantarse = true;
                valido=true;
            }
            else if (respuesta.equals("No")||respuesta.equals("NO")||respuesta.equals("no")) {
                plantarse = false;
                valido = true;
            }
            else {
                valido=false;
                System.out.printf("Respuesta introducida \u001b[1;31mno valida\u001b[0m. Prueba otra vez.\n\n");
            }
        } while (valido==false);
        return plantarse;
    }

    private static int juegaOrdenador(int pcPuntos){
        int npcPuntos=0, dado, ganaRival=0;
        do {
            System.out.println("\n                                           \u001b[0;35mTu rival\u001b[0m tira un dado.");
            dado = tirarDado();
            npcPuntos+=dado;
            System.out.printf("                                           \u001b[0;35mTu rival\u001b[0m ha sacado un: \u001b[36m%d\u001b[0m\n",dado);
            System.out.printf("                                          Lleva una puntuación de: \u001b[36m%d\u001b[0m\n\n",npcPuntos);
        } while (npcPuntos<pcPuntos&&npcPuntos<11);
        if (npcPuntos>11){
            System.out.println("                         \u001b[0;35mTu rival\u001b[0m se ha pasado de 11. \u001b[0;32mGanas la ronda\u001b[0m y sumas una porra.");
            return ganaRival=0;
        }
        else if (npcPuntos==11) {
            System.out.println("\u001b[0;35mTu rival\u001b[0m ha conseguido exactamente 11. \u001b[0;31mPierdes la ronda\u001b[0m y \u001b[0;35mtu rival\u001b[0m suma una porra de victoria y otra de bonificación.");
            return ganaRival = 2;
        }
        else {
            System.out.println("                 \u001b[0;35mTu rival\u001b[0m ha superado tus puntos. \u001b[0;31mPierdes la ronda\u001b[0m y \u001b[0;35mtu rival\u001b[0m suma una porra.");
            return ganaRival = 1;
        }
    }

    public static void main(String args[]){
        boolean plantarse,cerrar, salirMenu;
        int contador, pcPorras, npcPorras, pcPuntos, dado, resultOrdenador,optMenu;
        //Imprimimos el título y las reglas:
        System.out.print(msgTitulo());
        System.out.print(msgReglas());
        do {
            contador=0;
            pcPorras=0;
            npcPorras=0;
            do {
                cerrar=false;
                salirMenu=false;
                contador+=1;
                pcPuntos=0;
                System.out.printf(msgContador(),contador);
                System.out.println(msgTirarDado());
                lector.nextLine();
                dado = tirarDado();
                pcPuntos+=dado;
                System.out.printf("\n                                             Has sacado un: \u001b[36m%d\u001b[0m\n",dado);
                System.out.printf("                                       Llevas una puntuación de: \u001b[36m%d\u001b[0m\n",pcPuntos);
                do {
                    plantarse = plantarse();
                    if (!plantarse) {
                        dado = tirarDado();
                        pcPuntos += dado;
                        System.out.printf("                                             Has sacado un: \u001b[36m%d\u001b[0m\n", dado);
                        System.out.printf("                                       Llevas una puntuación de: \u001b[36m%d\u001b[0m\n", pcPuntos);
                    }
                } while (!plantarse&&pcPuntos<11);

                //A continuación valoramos el resultado de tus jugadas:
                if (pcPuntos>11){//Te has pasado de los 11 puntos.
                    System.out.println("                   Te has pasado de los 11 puntos. \u001b[1;31mPierdes la ronda\u001b[0m y \u001b[0;35mtu rival\u001b[0m suma una porra.\n");
                    npcPorras+=1;
                }
                else if (pcPuntos==11) {//Has conseguido exactamente 11 puntos.
                    System.out.println("    Has conseguido exactamente 11 puntos. \u001b[32mGanas la ronda\u001b[0m y sumas una porra por victoria y otra de bonificación.\n");
                    pcPorras+=2;
                }
                else {//Te has plantado y pasa el turno al ordenador.
                    resultOrdenador = juegaOrdenador(pcPuntos);
                    System.out.println(resultOrdenador);
                    switch (resultOrdenador){
                        case 0:
                            pcPorras+=1;
                            break;
                        case 1:
                            npcPorras+=1;
                            break;
                        case 2:
                            npcPorras+=2;
                            break;
                        default:
                            dispose();
                            System.out.println("\u001b[31mERROR INESPERADO\u001b[0m: System exit 1");
                            System.exit(0);
                    }
                }
                System.out.printf("                        Tus porras: %d                                 Porras del rival: %d\n\n\n\n",pcPorras,npcPorras);
            } while (npcPorras<5&&pcPorras<5);
            if (pcPorras>4){
                System.out.print(msgVictoria());
            }
            else {
                System.out.print(msgDerrota());
            }
            do {
                System.out.println("\u001b[36mPartida finalizada.\u001b[0m Opciones:\n   1. Ver las reglas.\n    2. Jugar de nuevo.\n     3. Salir del juego.\n\n");
                optMenu=Integer.parseInt(lector.nextLine());
                switch (optMenu){
                    case 1:
                        System.out.print(msgReglas());
                        break;
                    case 2:
                        salirMenu=true;
                        cerrar=false;
                        break;
                    case 3:
                        salirMenu=true;
                        cerrar=true;
                        break;
                    default:
                        System.out.println("\u001b[31mOpción introducida no valida, inserte una entrada válida.\u001b[0m");
                }
            } while (!salirMenu);
        } while (!cerrar);
        dispose();

    }
}
