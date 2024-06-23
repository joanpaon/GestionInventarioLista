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
package org.japo.java.entities.articulo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author José A. Pacheco - japolabs@gmail.com
 */
public final class UtilesArticulo {

    // Cabeceras Entrada y Salida
    public static final String CAB_ENT = """
            Entrada de Artículo
            ===================""";
    public static final String CAB_SAL = """
            SAlida de Artículo
            ==================""";

    // Cabeceras Mantenimiento
    public static final String CAB_ALT = """
            Alta de Artículo
            ================""";
    public static final String CAB_BAJ = """
            Baja de Artículo
            ================""";
    public static final String CAB_CON = """
            Consulta de Artículo
            ====================""";
    public static final String CAB_MOD = """
            Modificación de Artículo
            ========================""";
    public static final String CAB_LIS = """
         Idd  Nombre                          PVP  SA SM
        ----- ------------------------------ ----- -- --""";
    public static final String CAB_LIS_IDD = """
            Listado de Artículos por Referencia
            ===================================""";
    public static final String CAB_LIS_NOM = """
            Listado de Artículos por Nombre
            ===============================""";
    public static final String CAB_LIS_PRE = """
            Listado de Artículos por Precio
            ===============================""";
    public static final String CAB_LIS_SAC = """
            Listado de Artículos por Existencias
            ====================================""";

    // Mensajes de Usuario por Campo
    public static final String MSG_FLD_IDD = "Id ..........: ";
    public static final String MSG_FLD_NOM = "Nombre ......: ";
    public static final String MSG_FLD_PRE = "Precio ......: ";
    public static final String MSG_FLD_SAC = "Existencias .: ";
    public static final String MSG_FLD_SMI = "Mínimo ......: ";
    public static final String MSG_FLD_ENT = "Entrada .....: ";
    public static final String MSG_FLD_SAL = "Salida ......: ";

    // Mensajes de Error
    public static final String MSG_ERR = "ERROR: Entrada incorrecta";
    public static final String MSG_ERR_IDD = "ERROR: Id incorrecto";
    public static final String MSG_ERR_NOM = "ERROR: Nombre incorrecto";
    public static final String MSG_ERR_PRE = "ERROR: Precio incorrecto";
    public static final String MSG_ERR_SAC = "ERROR: Stock Actual incorrecto";
    public static final String MSG_ERR_SMI = "ERROR: Stock Mínimo incorrecto";

    // Mensajes de Aviso
    public static final String MSG_FND_NO = "ATENCIÓN: Artículo NO existe";
    public static final String MSG_FND_SI = "ATENCIÓN: Artículo YA existe";
    public static final String MSG_STK_NO = "ATENCIÓN: Artículo SIN existencias";
    public static final String MSG_STK_SI = "ATENCIÓN: Artículo CON existencias";
    public static final String MSG_STK_LW = "ATENCIÓN: Artículo con INSUFICIENTES existencias";
    public static final String MSG_OUT_TM = "ATENCIÓN: Artículo demandado en EXCESO";
    public static final String MSG_INN_TM = "ATENCIÓN: Artículo suministrado en EXCESO";
    public static final String MSG_DEL_OK = "ATENCIÓN: Artículo ELIMINADO definitivamente";

    // Objetos Comparator
    public static final Comparator<Articulo> CMP_IDD
            = (a1, a2) -> a1.getIdd().compareTo(a2.getIdd());
    public static final Comparator<Articulo> CMP_NOM
            = (a1, a2) -> a1.getNom().compareTo(a2.getNom());
    public static final Comparator<Articulo> CMP_PRE
            = (a1, a2) -> a1.getPre().compareTo(a2.getPre());
    public static final Comparator<Articulo> CMP_SAC
            = (a1, a2) -> a1.getSac().compareTo(a2.getSac());
    public static final Comparator<Articulo> CMP_SMI
            = (a1, a2) -> a1.getSmi().compareTo(a2.getSmi());

    // Valores Predeterminados
    public static final Long DEF_IDD = 0L;
    public static final String DEF_NOM = "No Definido";
    public static final Double DEF_PRE = 0.0;
    public static final Integer DEF_SAC = 0;
    public static final Integer DEF_SMI = 1;

    // Expresiones Regulares
    public static final String REG_IDD = "0|[1-9]\\d{0,4}";
    public static final String REG_NOM = "[\\wÁÉÍÓÚÜÑáéíóúüñ \\.\\-\\,()]{2,30}";
    public static final String REG_PRE = "(0|[1-9]\\d?)\\.(0|[1-9]\\d?|\\d[1-9])";
    public static final String REG_SAC = "0|[1-9]\\d?";
    public static final String REG_SMI = "0|[1-9]\\d?";

    // Valores Límite - Stock
    public static final int STK_MIN = 0;
    public static final int STK_MAX = 99;

    private UtilesArticulo() {
    }

    // Validación - Id
    public static final boolean validarId(Long id) {
        return UtilesValidacion.validar(id.toString(), REG_IDD);
    }

    // Validación - Nombre
    public static final boolean validarNombre(String nombre) {
        return UtilesValidacion.validar(nombre, REG_NOM);
    }

    // Validación - Precio
    public static final boolean validarPrecio(Double precio) {
        return UtilesValidacion.validar(precio.toString(), REG_PRE);
    }

    // Validación - Stock Actual
    public static final boolean validarStkAct(Integer stkAct) {
        return UtilesValidacion.validar(stkAct.toString(), REG_SAC);
    }

    // Validación - Stock Mínimo
    public static final boolean validarStkMin(Integer stkMin) {
        return UtilesValidacion.validar(stkMin.toString(), REG_SMI);
    }

    // Lista de Artículos + Id > Posición Artículo ( Algoritmo Simple )
    public static final int _buscarId(List<Articulo> lista, Long id) {
        // Referencia
        int index = 0;

        // Búsqueda
        try {
            boolean seekOK = true;
            do {
                if (index >= lista.size()) {
                    index = -1;
                    seekOK = false;
                } else if (Objects.equals(lista.get(index).getIdd(), id)) {
                    seekOK = false;
                } else {
                    index++;
                }
            } while (seekOK);
        } catch (Exception e) {
            index = -1;
        }

        // Retorno 
        return index;
    }

    // Lista de Artículos + Id > Posición Artículo
    public static final int buscarId(List<Articulo> lista, Long id) {
        // Ordenar Lista - Id
        lista.sort(CMP_IDD);

        // Referencia
        int index;

        // Búsqueda
        try {
            // Objeto de Búsqueda
            Articulo a = generarArticuloId(id);

            // Buscar
            index = Collections.binarySearch(lista, a, CMP_IDD);
        } catch (Exception e) {
            // No Encontrado
            index = -1;
        }

        // Retorno
        return index;
    }

    // Artículo > Consola - Formato Registro
    public static final void mostrarArticulo(Articulo a) {
        System.out.printf("%s%d%n", MSG_FLD_IDD, a.getIdd());
        System.out.printf("%s%s%n", MSG_FLD_NOM, a.getNom());
        System.out.printf(Locale.ENGLISH, "%s%.2f%n", MSG_FLD_PRE, a.getPre());
        System.out.printf("%s%d%n", MSG_FLD_SAC, a.getSac());
        System.out.printf("%s%d%n", MSG_FLD_SMI, a.getSmi());
    }

    private static Articulo generarArticuloId(Long id) throws Exception {
        return new Articulo(
                id,
                DEF_NOM,
                DEF_PRE,
                DEF_SAC,
                DEF_SMI);
    }

    // Listado - Id
    public static final void listarIdd(List<Articulo> lista) {
        // Ordenar - Id
        lista.sort(CMP_IDD);

        // Cabecera - Id
        System.out.println(CAB_LIS_IDD);

        // Listar
        listar(lista);
    }

    // Listado - Nombre
    public static final void listarNom(List<Articulo> lista) {
        // Ordenar - Nombre
        lista.sort(CMP_NOM);

        // Cabecera - Nombre
        System.out.println(CAB_LIS_NOM);

        // Listar
        listar(lista);
    }

    // Listado - Precio
    public static final void listarPre(List<Articulo> lista) {
        // Ordenar - Precio
        lista.sort(CMP_PRE);

        // Cabecera - Precio
        System.out.println(CAB_LIS_PRE);

        // Listar
        listar(lista);
    }

    // Listado - Existencias
    public static final void listarStk(List<Articulo> lista) {
        // Ordenar - Existencias
        lista.sort(CMP_SAC);

        // Cabecera - Existencias
        System.out.println(CAB_LIS_SAC);

        // Listar
        listar(lista);
    }

    // Lista Artículos > Listado Consola
    public static final void listar(List<Articulo> lista) {
        try {
            // Cabecera
            System.out.println(CAB_LIS);

            // Listado
            for (Articulo a : lista) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println("AVISO: Nada que listar");
        } finally {
            // Pausa
            UtilesEntrada.hacerPausa();
        }
    }

    // Entradas
    public static final void comprar(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_ENT);

        // Consola > Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Buscar Artículo
        int index = buscarId(lista, id);

        // Procesar Búsqueda
        if (index <= -1) {
            // Artículo NO existe
            UtilesEntrada.hacerPausa(MSG_FND_NO);
        } else {
            // Lista + Index > Artículo
            Articulo a = lista.get(index);

            // Mostrar Artículo
            mostrarArticulo(a);

            // Separador
            System.out.println("---");

            // Entrada Suministros
            int entrada = leerEntradas();

            // Separador
            System.out.println("---");

            // Validar Suministro + Existencias
            if (a.getSac() + entrada > STK_MAX) {
                UtilesEntrada.hacerPausa(MSG_INN_TM);
            } else {
                // Artículo > Stock Actual
                int stkAct = a.getSac();

                // Stock Actual + Entrada > Artículo
                a.setSac(stkAct + entrada);

                // Mostrar Artículo
                mostrarArticulo(a);
            }

            // Pausa
            UtilesEntrada.hacerPausa();
        }
    }

    // Salidas
    public static final void vender(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_SAL);

        // Consola > Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Buscar Artículo
        int index = buscarId(lista, id);

        // Procesar Búsqueda
        if (index <= -1) {
            // Artículo NO existe
            UtilesEntrada.hacerPausa(MSG_FND_NO);
        } else {
            // Lista + Index > Artículo
            Articulo a = lista.get(index);

            // Mostrar Artículo
            mostrarArticulo(a);

            // Separador
            System.out.println("---");

            // Obtener Existencias
            int stkAct = a.getSac();

            // Salidas Suministros
            int salida = leerSalidas(stkAct);

            // Separador
            System.out.println("---");

            // Validar Existencias - Pedido
            if (stkAct - salida < STK_MIN) {
                UtilesEntrada.hacerPausa(MSG_OUT_TM);
            } else {
                // Stock Actual + Entrada > Artículo
                a.setSac(stkAct - salida);

                // Mostrar Artículo
                mostrarArticulo(a);

                // Pausa
                UtilesEntrada.hacerPausa();
            }
        }
    }

    // Altas
    public static final void crear(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_ALT);

        // Entrada Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Posición Articulo
        int index = buscarId(lista, id);

        // Procesar Posición
        if (index > -1) {
            // Artículo YA Existe
            System.out.println(MSG_FND_SI);
        } else {
            // Consola > Nuevos Valores Campos
            String nombre = leerNombre();
            double precio = leerPrecio();
            int stkMin = leerStkMin();

            // Separación
            System.out.println("---");

            // Crea Artículo
            Articulo a = new Articulo();
            a.setIdd(id);
            a.setNom(nombre);
            a.setPre(precio);
            a.setSac(DEF_SAC);
            a.setSmi(stkMin);

            // Articulo > Lista
            lista.add(a);

            // Mostrar Artículo
            mostrarArticulo(a);
        }

        // Pausa
        UtilesEntrada.hacerPausa();
    }

    // Bajas
    public static final void borrar(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_BAJ);

        // Consola > Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Búsqueda Artículo
        int index = buscarId(lista, id);

        // Procesar Búsqueda
        if (index <= -1) {
            // Artículo NO Existe
            System.out.println(MSG_FND_NO);
        } else if (lista.get(index).getSac() > 0) {
            // Stock AÚN Disponible
            System.out.println(MSG_STK_SI);
        } else {
            // Mostrar Artículo Encontrado
            mostrarArticulo(lista.get(index));

            // Eliminando Artículo
            lista.remove(index);

            // Mensaje Artículo Eliminado
            System.out.println(MSG_DEL_OK);
        }

        // Pausa
        UtilesEntrada.hacerPausa();
    }

    // Consultas
    public static final void consultar(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_CON);

        // Entrada Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Búsqueda Artículo
        int index = buscarId(lista, id);

        // Procesar Búsqueda
        if (index <= -1) {
            // Artículo NO Existe
            System.out.println(MSG_FND_NO);
        } else {
            // Mostrar Artículo Encontrado
            mostrarArticulo(lista.get(index));
        }

        // Pausa
        UtilesEntrada.hacerPausa();
    }

    // Modificaciones
    public static final void cambiar(List<Articulo> lista) {
        // Cabecera
        System.out.println(CAB_MOD);

        // Entrada Referencia Artículo
        Long id = leerId();

        // Separación
        System.out.println("---");

        // Posición Articulo
        int index = buscarId(lista, id);

        // Procesar Posición
        if (index <= -1) {
            // Artículo NO Existe
            System.out.println(MSG_FND_NO);
        } else {
            // Lista + Posición > Actículo
            Articulo a = lista.get(index);

            // Mostrar Artículo
            mostrarArticulo(a);

            // Separación
            System.out.println("---");

            // Consola > Nuevos Valores Campos
            String nombre = leerNombre(a.getNom());
            double precio = leerPrecio(a.getPre());
            int stkMin = leerStkMin(a.getSmi());

            // Separación
            System.out.println("---");

            // Actualiza Artículo
            a.setNom(nombre);
            a.setPre(precio);
            a.setSmi(stkMin);

            // Mostrar Artículo
            mostrarArticulo(a);
        }

        // Pausa
        UtilesEntrada.hacerPausa();
    }

    // Consola > Entradas
    public static final int leerEntradas() {
        return UtilesEntrada.leerEntero(MSG_FLD_ENT, MSG_ERR, STK_MIN, STK_MAX);
    }

    // Consola > Salidas
    public static final int leerSalidas(int stkMax) {
        return UtilesEntrada.leerEntero(MSG_FLD_SAL, MSG_ERR, STK_MIN, stkMax);
    }

    // Entrada - Referencia
    public static final Long leerId() {
        return (long) UtilesEntrada.leerEntero(MSG_FLD_IDD, MSG_ERR, REG_IDD);
    }

    // Entrada - Nombre
    public static final String leerNombre() {
        return UtilesEntrada.leerTexto(MSG_FLD_NOM, MSG_ERR, REG_NOM);
    }

    // Entrada - Nombre (Sugerencia)
    public static final String leerNombre(String sugerencia) {
        return UtilesEntrada.leerTexto(MSG_FLD_NOM, MSG_ERR, REG_NOM, sugerencia);
    }

    // Entrada - Precio
    public static final double leerPrecio() {
        return UtilesEntrada.leerReal(MSG_FLD_PRE, MSG_ERR, REG_PRE);
    }

    // Entrada - Precio (Sugerencia)
    public static final double leerPrecio(double sugerencia) {
        return UtilesEntrada.leerReal(MSG_FLD_PRE, MSG_ERR, REG_PRE, sugerencia);
    }

    // Entrada - Stock Actual
    public static final int leerStkAct() {
        return UtilesEntrada.leerEntero(MSG_FLD_SAC, MSG_ERR, REG_SAC);
    }

    // Entrada - Stock Actual (Sugerencia)
    public static final int leerStkAct(int sugerencia) {
        return UtilesEntrada.leerEntero(MSG_FLD_SAC, MSG_ERR, REG_SAC, sugerencia);
    }

    // Entrada - Stock Mínimo
    public static final int leerStkMin() {
        return UtilesEntrada.leerEntero(MSG_FLD_SMI, MSG_ERR, REG_SMI);
    }

    // Entrada - Stock Mínimo (Sugerencia)
    public static final int leerStkMin(int sugerencia) {
        return UtilesEntrada.leerEntero(MSG_FLD_SMI, MSG_ERR, REG_SMI, sugerencia);
    }
}
