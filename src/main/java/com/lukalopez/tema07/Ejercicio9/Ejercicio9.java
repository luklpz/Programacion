package com.lukalopez.tema07.Ejercicio9;

public class Ejercicio9 {
    public static void pruebaErrores(int[] arrayNoInicializado, int dividendo, int divisor, int capacidadArray, int[] arrayInicializado){
        boolean arithmeticZeroDivisorException = false;
        boolean nullArrayPointerException = false;
        boolean indexArrayOutOfBoundsException = false;

        for (int i = 0; i < 4; i++) {
            try {
                //Si ya ha ocurrido este error lo omitimos
                if (!arithmeticZeroDivisorException){
                    if (divisor==0){
                        throw new ArithmeticZeroDivisorException("ArithmeticZeroDivisorException: No se puede dividir por cero.");
                    } else {
                        System.out.println(dividendo/divisor);
                    }

                    //Si ya ha ocurrido este error lo omitimos
                } else if (!nullArrayPointerException) {
                    if (arrayNoInicializado==null){
                        throw new NullArrayPointerException("NullArrayPointerException: Se ha introducido un array no inicializado.");
                    } else {
                        System.out.println(arrayNoInicializado[3]);
                    }

                    //Si ya ha ocurrido este error lo omitimos
                } else if (!indexArrayOutOfBoundsException){
                    if (capacidadArray>arrayInicializado.length) {
                        throw new IndexArrayOutOfBoundsException("IndexArrayOutOfBoundsException: Se ha superado la capacidad del array.");
                    } else {
                        for (int j = 0; j < capacidadArray; j++) {
                            System.out.println(arrayInicializado[j]);
                        }
                    }
                }
            } catch (ArithmeticZeroDivisorException azde) {
                System.out.println(azde.getMessage());
                arithmeticZeroDivisorException = true;
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
                nullArrayPointerException = true;
            } catch (IndexArrayOutOfBoundsException iaoobe) {
                System.out.println(iaoobe.getMessage());
                indexArrayOutOfBoundsException = true;
            }
        }
    }

    public static void main(String[] args) {
        pruebaErrores(null,2,0,4, new int[]{});
    }
}
