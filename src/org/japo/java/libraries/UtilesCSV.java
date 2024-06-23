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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.japo.java.entities.articulo.Articulo;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesCSV {

    // Separadores
    public static final String REG_SEP_LEC = "\\s*,\\s*";
    public static final String REG_SEP_ESC = ",";

    // Fichero con Datos - CSV
    public static final String FICHERO_CSV = "datos.csv";

    // Mensajes
    public static final String MSG_ERR_CSV = "ERROR: No se puede acceder al archivo";
    public static final String MSG_ERR_LIN = "ERROR: Linea no gestionable";

    // Constructor Inaccesible
    private UtilesCSV() {
    }

    // Primera Linea Archivo CSV > Array Tokens
    public static final String[] importarCabecera(String fichero)
            throws Exception {
        // Lista Items (Vacio)
        String[] items;

        // Importar Items
        try (FileReader fr = new FileReader(fichero); //
                 BufferedReader br = new BufferedReader(fr)) {
            // Fichero CSV > Linea Items (1ª Linea)
            String linea = br.readLine();

            // Linea Items > Lista Items
            items = convertir(linea);
        }

        // Devolver Items
        return items;
    }

    // Array Tokens > Primera Linea Archivo CSV
    public static final void exportarCabecera(String[] items, String fichero)
            throws Exception {
        // Lectura de un fichero de texto
        try (FileWriter fw = new FileWriter(fichero); //
                 PrintWriter pw = new PrintWriter(fw)) {

            // Lista Items > Linea Items
            String linea = convertir(items);

            // Primer item por separado
            pw.print(linea);

            // Confirmacion
            pw.flush();
        }
    }

    // Array Tokens > Linea Tokens
    public static final String convertir(String[] tokens, String separador) {
        // Acumulador
        StringBuilder sb = new StringBuilder();

        // Primer item por separado
        sb.append(tokens[0]);

        // Resto de los items
        for (int i = 1; i < tokens.length; i++) {
            sb.append(separador);
            sb.append(tokens[i]);
        }

        // Devuelve Secuencia
        return sb.toString();
    }

    // Array Tokens > Linea Tokens - Separador Predeterminado
    public static final String convertir(String[] items) {
        return convertir(items, REG_SEP_ESC);
    }

    // Linea Tokens > Array Tokens
    public static final String[] convertir(String secuencia, String separador) {
        return secuencia.split(separador);
    }

    // Linea Tokens > Array Tokens - Separador Predeterminado
    public static final String[] convertir(String secuencia) {
        return convertir(secuencia, REG_SEP_LEC);
    }

    // Fichero CSV > Lista Artículos ( Ejemplo )
    public static final void importarDatos(List<Articulo> lista, String fichero) {
        try (FileReader fr = new FileReader(fichero); //
                 BufferedReader br = new BufferedReader(fr)) {
            // Referencia Linea Actual
            String linea;

            // Bucle de Acceso al Fichero
            do {
                // Fichero > Linea
                linea = br.readLine();

                try {
                    // Validación de la linea
                    if (linea != null) {
                        // Linea > Tokens
                        String[] tokens = linea.split(REG_SEP_LEC);

                        // Tokens > Datos
                        Long id = Long.valueOf(tokens[0]);
                        String nombre = tokens[1];
                        double precio = Double.parseDouble(tokens[2]);
                        Integer stkAct = Integer.valueOf(tokens[3]);
                        Integer stkMin = Integer.valueOf(tokens[4]);

                        // Datos > Articulo
                        Articulo a = new Articulo(id, nombre, precio, stkAct, stkMin);

                        // Articulo > Lista
                        lista.add(a);
                    }
                } catch (Exception e) {
                    System.out.println(MSG_ERR_LIN);
                }
            } while (linea != null);
        } catch (Exception e) {
            System.out.println(MSG_ERR_CSV);
        }
    }

    // Fichero CSV > Lista Artículos ( Ejemplo )
    public static final void importarDatos(List<Articulo> lista) {
        importarDatos(lista, FICHERO_CSV);
    }

    // Lista Artículos > Fichero CSV ( Ejemplo )
    public static final void exportarDatos(List<Articulo> lista, String fichero) {
        try (FileWriter fw = new FileWriter(fichero)) {
            for (Articulo a : lista) {
                // Campos > Linea
                StringBuilder linea = new StringBuilder();
                linea.append(a.getIdd()).append(REG_SEP_ESC);
                linea.append(a.getNom()).append(REG_SEP_ESC);
                linea.append(a.getPre()).append(REG_SEP_ESC);
                linea.append(a.getSac()).append(REG_SEP_ESC);
                linea.append(a.getSmi()).append("\n");

                // Linea > Fichero
                fw.write(linea.toString());
            }
        } catch (Exception e) {
            System.out.println(MSG_ERR_CSV);
        }
    }

    // Lista Artículos > Fichero CSV ( Ejemplo )
    public static final void exportarDatos(List<Articulo> lista) {
        exportarDatos(lista, FICHERO_CSV);
    }
}
