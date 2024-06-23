/*
 * Copyright 2024 José A. Pacheco - japolabs@gmail.com.
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

import java.util.List;
import org.japo.java.entities.articulo.Articulo;
import org.japo.java.entities.articulo.UtilesArticulo;

/**
 *
 * @author José A. Pacheco - japolabs@gmail.com
 */
public final class UtilesApp {

    // Mensajes de Error
    public static final String MSG_ERR = "ERROR: Entrada incorrecta";

    // Menú Principal
    public static final String OPC_PPAL = "120";
    public static final String MNU_PPAL = """
            GESTIÓN DE INVENTARIO
            =====================
            [ 1 ] Entradas y Salidas
            [ 2 ] Mantenimiento
            ---
            [ 0 ] Salir
            -
            Opción ...:\s""";

    // Menú Entradas y Salidas
    public static final String OPC_ENSA = "120";
    public static final String MNU_ENSA = """
            MENÚ DE ENTRADAS Y SALIDAS
            ==========================
            [ 1 ] Entradas
            [ 2 ] Salidas
            ---
            [ 0 ] Menú Anterior
            -
            Opción ...:\s""";

    // Menú Mantenimiento
    public static final String OPC_MANT = "123450";
    public static final String MNU_MANT = """
            MENÚ DE MANTENIMIENTO
            =====================
            [ 1 ] Altas
            [ 2 ] Bajas
            [ 3 ] Consultas
            [ 4 ] Modificaciones
            [ 5 ] Listados
            ---
            [ 0 ] Menú Anterior
            -
            Opción ...:\s""";

    // Menú Listados
    public static final String OPC_LIST = "12340";
    public static final String MNU_LIST = """
            MENÚ DE LISTADOS
            ================
            [ 1 ] Listado por Referencia
            [ 2 ] Listado por Nombre
            [ 3 ] Listado por Precio
            [ 4 ] Listado por Existencias
            ---
            [ 0 ] Menú Anterior
            -
            Opción ...:\s""";

    // Mensaje Despedida
    public static final String MSG_BYE = """
        Programa Terminado por el Usuario
        Fin de la Sesión de Trabajo
        Gracias por utilizar esta Aplicación""";

    // Constructor Predeterminado ( Oculto )
    private UtilesApp() {
    }

    // Menú Principal
    public static final void lanzarMenuPpal(List<Articulo> lista) {
        // Referencia
        char opcion;

        // Gestión Menú
        do {
            // Interacción
            opcion = UtilesEntrada.leerCaracter(MNU_PPAL, MSG_ERR, OPC_PPAL);

            // Separador
            System.out.println("---");

            // Procesado
            switch (opcion) {
                case '1' ->
                    lanzarMenuEnSa(lista);
                case '2' ->
                    lanzarMenuMant(lista);
            }
        } while (opcion != '0');

        // Mensaje Despedida
        System.out.println(MSG_BYE);
    }

    // Menú Entradas y Salidas
    public static final void lanzarMenuEnSa(List<Articulo> lista) {
        // Referencia
        char opcion;

        // Gestión Menú
        do {
            // Interacción
            opcion = UtilesEntrada.leerCaracter(MNU_ENSA, MSG_ERR, OPC_ENSA);

            // Separador
            System.out.println("---");

            // Procesado
            switch (opcion) {
                case '1' ->
                    UtilesArticulo.comprar(lista);
                case '2' ->
                    UtilesArticulo.vender(lista);
            }
        } while (opcion != '0');
    }

    // Menú Mantenimiento
    public static final void lanzarMenuMant(List<Articulo> lista) {
        // Referencia
        char opcion;

        // Gestión Menú
        do {
            // Interacción
            opcion = UtilesEntrada.leerCaracter(MNU_MANT, MSG_ERR, OPC_MANT);

            // Separador
            System.out.println("---");

            // Procesado
            switch (opcion) {
                case '1' ->
                    UtilesArticulo.crear(lista);
                case '2' ->
                    UtilesArticulo.borrar(lista);
                case '3' ->
                    UtilesArticulo.consultar(lista);
                case '4' ->
                    UtilesArticulo.cambiar(lista);
                case '5' ->
                    lanzarMenuList(lista);
            }
        } while (opcion != '0');
    }

    // Listados
    public static final void lanzarMenuList(List<Articulo> lista) {
        // Referencia
        char opcion;

        // Gestión Menu
        do {
            // Interacción
            opcion = UtilesEntrada.leerCaracter(MNU_LIST, MSG_ERR, OPC_LIST);

            // Separador
            System.out.println("---");

            // Procesado
            switch (opcion) {
                case '1' ->
                    UtilesArticulo.listarIdd(lista);
                case '2' ->
                    UtilesArticulo.listarNom(lista);
                case '3' ->
                    UtilesArticulo.listarPre(lista);
                case '4' ->
                    UtilesArticulo.listarStk(lista);
            }
        } while (opcion != '0');
    }
}
