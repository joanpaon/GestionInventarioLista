/*
 * Copyright 2019 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesArrays {

    // Sistema Números Aleatórios
//    public static final Random RND = new Random();
    // Array int >> Total
    public static final int acumular(int[] listaDatos) {
        // Acumulador
        int total = 0;

        // Proceso
        for (int dato : listaDatos) {
            total += dato;
        }

        // Devolución Valor
        return total;
    }

    // Array double >> Total
    public static final double acumular(double[] listaDatos) {
        // Acumulador
        double total = 0;

        // Proceso
        for (double dato : listaDatos) {
            total += dato;
        }

        // Devolución Valor
        return total;
    }

    // > Array Char Aleatorio
    public static final char[] generar(int size, char min, char max) {
        // Array Vacío
        char[] datos = new char[size];

        // Generación de datos
        for (int i = 0; i < size; i++) {
            datos[i] = UtilesAleatorios.generarCaracter(min, max);
        }

        // Devolución Array
        return datos;
    }

    // > Array Entero Aleatorio
    public static final int[] generar(int size, int min, int max) {
        // Array Vacío
        int[] datos = new int[size];

        // Generación de datos
        for (int i = 0; i < size; i++) {
            datos[i] = UtilesAleatorios.generarEntero(min, max);
        }

        // Devolución Array
        return datos;
    }

    // Número aleatorio >> Array Real
    public static final double[] generar(int size, double min, double max) {
        // Array Vacío
        double[] datos = new double[size];

        // Generación de datos
        for (int i = 0; i < size; i++) {
            datos[i] = UtilesAleatorios.generarReal(min, max);
        }

        // Devolución Array
        return datos;
    }

    // > Array char Inicializado
    public static final void inicializar(char[] lista, char dato) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = dato;
        }
    }

    // > Array int Inicializado
    public static final void inicializar(int[] lista, int dato) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = dato;
        }
    }

    // > Array double Inicializado
    public static final void inicializar(double[] lista, double dato) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = dato;
        }
    }

    // > Array boolean Inicializado
    public static final void inicializar(boolean[] lista, boolean dato) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = dato;
        }
    }

    // Búsqueda Secuencial - Enteros
    public static final int buscar(int[] lista, int clave) {
        // Marcador de posición
        int posicion = 0;

        // Semáforo de Proceso de Búsqueda
        boolean finBusquedaOK = false;

        // Proceso de búsqueda
        do {
            if (posicion >= lista.length) {
                finBusquedaOK = true;
                posicion = -1;
            } else if (lista[posicion] == clave) {
                finBusquedaOK = true;
            } else {
                posicion++;
            }
        } while (!finBusquedaOK);

        // Posición de la clave en el array
        return posicion;
    }

    // Búsqueda Secuencial - Reales
    public static final int buscar(double[] lista, double clave) {
        // Marcador de posición
        int posicion = 0;

        // Semáforo de Proceso de Búsqueda
        boolean finBusquedaOK = false;

        // Proceso de búsqueda
        do {
            if (posicion >= lista.length) {
                finBusquedaOK = true;
                posicion = -1;
            } else if (lista[posicion] == clave) {
                finBusquedaOK = true;
            } else {
                posicion++;
            }
        } while (!finBusquedaOK);

        // Posición de la clave en el array
        return posicion;
    }

    // Búsqueda Secuencial - String
    public static final int buscar(String[] lista, String clave) {
        // Marcador de posición
        int posicion = 0;

        // Semáforo de Proceso de Búsqueda
        boolean finBusquedaOK = false;

        // Proceso de búsqueda
        do {
            if (posicion >= lista.length) {
                finBusquedaOK = true;
                posicion = -1;
            } else if (lista[posicion].equals(clave)) {
                finBusquedaOK = true;
            } else {
                posicion++;
            }
        } while (!finBusquedaOK);

        // Posición de la clave en el array
        return posicion;
    }

    // Ordenación - Burbuja (Ascendente)
    public static final void ordenarBurbuja(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {
                // Actual > Siguiente
                if (lista[j] > lista[j + 1]) {
                    // Intercambiar
                    int aux = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = aux;
                }
            }
        }
    }

    // Ordenación - Inserción (Ascendente)
    public static final void ordenarInsercion(int[] lista) {
        for (int i = 1; i <= lista.length - 1; i++) {
            // Elemento Actual
            int aux = lista[i];

            // Hacer Hueco a Izquierda
            int j = i - 1;
            while (j >= 0 && aux < lista[j]) {
                lista[j + 1] = lista[j];
                j = j - 1;
            }

            // Insertar Elemento Actual en Hueco
            lista[j + 1] = aux;
        }
    }

    // Ordenación - Selección (Ascendente)
    public static final void ordenarSeleccion(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            // Posición de Mínimo
            int pos = i;

            // Seleccionar Posición de Minimo a Derecha
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[pos]) {
                    pos = j;
                }
            }

            // Intercambiar
            int aux = lista[i];
            lista[i] = lista[pos];
            lista[pos] = aux;
        }
    }

    // Desordenar Lista - caracter
    public static final char[] desordenar(char[] lista) {
        for (int i = 0; i < lista.length; i++) {
            // Posición Recíproca Aleatoria
            int posRnd = UtilesAleatorios.generarEntero(0, lista.length - 1);

            // Intercambio Recíproco
            char aux = lista[posRnd];
            lista[posRnd] = lista[i];
            lista[i] = aux;
        }

        // Retorno Lista Desordenada
        return lista;
    }

    // Desordenar Lista - entero
    public static final int[] desordenar(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            // Posición Recíproca Aleatoria
            int posRnd = UtilesAleatorios.generarEntero(0, lista.length - 1);

            // Intercambio Recíproco
            int aux = lista[posRnd];
            lista[posRnd] = lista[i];
            lista[i] = aux;
        }

        // Retorno Lista Desordenada
        return lista;
    }

    // Desordenar - real
    public static final double[] desordenar(double[] lista) {
        for (int i = 0; i < lista.length; i++) {
            // Posición Recíproca Aleatoria
            int posRnd = UtilesAleatorios.generarEntero(0, lista.length - 1);

            // Intercambio Recíproco
            double aux = lista[posRnd];
            lista[posRnd] = lista[i];
            lista[i] = aux;
        }

        // Retorno Lista Desordenada
        return lista;
    }

    // Desordenar - boolean
    public static final boolean[] desordenar(boolean[] lista) {
        for (int i = 0; i < lista.length; i++) {
            // Posición Recíproca Aleatoria
            int posRnd = UtilesAleatorios.generarEntero(0, lista.length - 1);

            // Intercambio Recíproco
            boolean aux = lista[posRnd];
            lista[posRnd] = lista[i];
            lista[i] = aux;
        }

        // Retorno Lista Desordenada
        return lista;
    }

    // Desordenar - String
    public static final String[] desordenar(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            // Posición Recíproca Aleatoria
            int posRnd = UtilesAleatorios.generarEntero(0, lista.length - 1);

            // Intercambio Recíproco
            String aux = lista[posRnd];
            lista[posRnd] = lista[i];
            lista[i] = aux;
        }

        // Retorno Lista Desordenada
        return lista;
    }

    // int[] > Posicion (Primera) Valor Máximo
    public static final int obtenerMaximo(int[] lista) {
        // Primero es maximo
        int posicion = 0;

        // Recorrer a partir del segundo
        for (int actual = 1; actual < lista.length; actual++) {
            posicion = lista[actual] > lista[posicion] ? actual : posicion;
        }

        // Devolver posicion
        return posicion;
    }

    // int[] > Posición (Primera) Valor Mínimo
    public static final int obtenerMinimo(int[] lista) {
        // Primero es maximo
        int posicion = 0;

        // Recorrer a partir del segundo
        for (int actual = 1; actual < lista.length; actual++) {
            posicion = lista[actual] < lista[posicion] ? actual : posicion;
        }

        // Devolver posicion
        return posicion;
    }

    // clave + lista > Número ocurrencias
    public static final int contarOcurrencias(int[] lista, int clave) {
        // Contador ocurrencias
        int contador = 0;

        // Recorrer
        for (int item : lista) {
            contador = item == clave ? contador + 1 : contador;
        }

        // Devolver contador
        return contador;
    }

    // Array char > Consola ( Lineas )
    public static final void mostrar(char[] lista, String msg) {
        for (int i = 0; lista != null && i < lista.length; i++) {
            System.out.printf("%s %d ...: %c%n", msg != null ? msg : "", i + 1, lista[i]);
        }
    }

    // Array int > Consola ( Lineas )
    public static final void mostrar(int[] lista, String msg) {
        for (int i = 0; lista != null && i < lista.length; i++) {
            System.out.printf("%s %d ...: %d%n", msg != null ? msg : "", i + 1, lista[i]);
        }
    }

    // Array double > Consola ( Lineas )
    public static final void mostrar(double[] lista, String msg) {
        for (int i = 0; lista != null && i < lista.length; i++) {
            System.out.printf("%s %d ...: %.2f%n", msg != null ? msg : "", i + 1, lista[i]);
        }
    }
}
