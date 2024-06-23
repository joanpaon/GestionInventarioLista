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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesEntrada {

    // Mensajes Predeterminados
    public static final String MSG_USR = "Dato .....: ";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta";
    public static final String MSG_BRK = "Pulse [Intro] para continuar ...";

    // Locales
    public static final Locale LCL_ESP = Locale.of("es", "ES");
    public static final Locale LCL_ENG = Locale.of("en", "US");

    // Scanner + Codificación Windows
//    public static final Scanner SCN
//            = new Scanner(System.in, "Windows-1252")
//                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Scanner SCN
            = new Scanner(System.in, "UTF-8")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
//    public static final Scanner SCN
//            = new Scanner(System.in, "ISO-8859-1")
//                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    // Página de Códigos Terminal de Windows
//    public static final Scanner SCN
//            = new Scanner(System.in, "CP850")
//                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
//    public static final Scanner SCN
//            = new Scanner(System.in, "CP1252")
//                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    // Consola >> Entero
    public static final int leerEntero(String msgUsr, String msgErr) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola + Valor Sugerido > Entero
    @SuppressWarnings({"SleepWhileInLoop", "UseSpecificCatch"})
    public static final int leerEntero(String msgUsr, String msgErr,
            int sugerencia) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Mensaje de Usuario
                System.out.print(msgUsr);

                // Espera que se complete print - Código Basura
                Thread.sleep(400);

                // Texto > Portapapeles > Entrada - Código Basura
                UtilesPortapapeles.inyectar(sugerencia + "");

                // Entrada dato
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                // Vaciar Buffer
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Entero
    public static final int leerEntero(String msgUsr) {
        return UtilesEntrada.leerEntero(msgUsr, MSG_ERR);
    }

    // Consola >> Entero
    public static final int leerEntero(String msgUsr, int sugerencia) {
        return UtilesEntrada.leerEntero(msgUsr, MSG_ERR, sugerencia);
    }

    // Consola >> Entero [min .. max]
    public static final int leerEntero(String msgUsr, String msgErr,
            int min, int max) {
        // Número a Devolver
        int dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);

            // Validar Rango
            rangoOK = dato >= min && dato <= max;

            // Rango incorrecto >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Entero [min .. max]
    public static final int leerEntero(String msgUsr, String msgErr,
            int min, int max, int sugerencia) {
        // Número a Devolver
        int dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr, sugerencia);

            // Validar Rango
            rangoOK = dato >= min && dato <= max;

            // Rango incorrecto >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Entero [min .. max]
    public static final int leerEntero(String msgUsr,
            int min, int max, int sugerencia) {
        return UtilesEntrada.leerEntero(msgUsr, MSG_ERR, min, max, sugerencia);
    }

    // Consola >> Entero [Lista posibles Valores]
    public static final int leerEntero(String msgUsr, String msgErr, int lista[]) {
        // Número a Devolver
        int dato;

        // Semáforo Validación
        boolean datoOK;

        // Bucle Validación
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);

            // Validar Existencia Entero
            datoOK = UtilesArrays.buscar(lista, dato) > -1;

            // Entero Inexistente > Mensaje de error
            if (!datoOK) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Entero [Lista posibles Valores]
    public static final int leerEntero(String msgUsr, int lista[]) {
        return UtilesEntrada.leerEntero(msgUsr, MSG_ERR, lista);
    }

    // Consola + Expresión Regular > Entero
    public static final int leerEntero(String msgUsr, String msgErr, String er) {
        // Referencia
        int data = 0;

        // Bucle Validación
        boolean dataOK;
        do {
            // Consola > Dato
            data = leerEntero(msgUsr, msgErr);

            // Validar Dato
            dataOK = UtilesValidacion.validar(data + "", er);

            // Procesar Validación
            if (!dataOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dataOK);

        // Retorno
        return data;
    }

    // Consola + Expresión Regular > Entero
    public static final int leerEntero(String msgUsr, String msgErr,
            String er, int sugerencia) {
        // Referencia
        int data = 0;

        // Bucle Validación
        boolean dataOK;
        do {
            // Consola > Dato
            data = leerEntero(msgUsr, msgErr, sugerencia);

            // Validar Dato
            dataOK = UtilesValidacion.validar(data + "", er);

            // Procesar Validación
            if (!dataOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dataOK);

        // Retorno
        return data;
    }

    // Consola >> Real
    public static final double leerReal(String msgUsr, String msgErr) {
        // Dato a introducir
        double dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextDouble();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Real
    @SuppressWarnings({"SleepWhileInLoop", "UseSpecificCatch"})
    public static final double leerReal(String msgUsr, String msgErr,
            double sugerencia) {
        // Dato a introducir
        double dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Mensaje de Usuario
                System.out.print(msgUsr);

                // Espera que se complete print - Código Basura
                Thread.sleep(400);

                // Texto > Portapapeles > Entrada - Código Basura
                UtilesPortapapeles.inyectar(sugerencia + "");

                // Entrada dato
                dato = SCN.nextDouble();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Real
    public static final double leerReal(String msgUsr) {
        return UtilesEntrada.leerReal(msgUsr, MSG_ERR);
    }

    // Consola >> Real
    public static final double leerReal(String msgUsr, double sugerencia) {
        return UtilesEntrada.leerReal(msgUsr, MSG_ERR, sugerencia);
    }

    // Consola >> Real [min .. max]
    public static final double leerReal(String msgUsr, String msgErr,
            double min, double max) {
        // Número a Devolver
        double dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerReal(msgUsr, msgErr);

            // Validar Rango Entero
            rangoOK = dato >= min && dato <= max;

            // Rango Erróneo >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Real [min .. max]
    public static final double leerReal(String msgUsr, String msgErr,
            double min, double max, double sugerencia) {
        // Número a Devolver
        double dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerReal(msgUsr, msgErr, sugerencia);

            // Validar Rango Entero
            rangoOK = dato >= min && dato <= max;

            // Rango Erróneo >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Real [min .. max]
    public static final double leerReal(String msgUsr, double min, double max) {
        return UtilesEntrada.leerReal(msgUsr, MSG_ERR, min, max);
    }

    // Consola >> Real [min .. max]
    public static final double leerReal(String msgUsr,
            double min, double max, double sugerencia) {
        return UtilesEntrada.leerReal(msgUsr, MSG_ERR, min, max, sugerencia);
    }

    // Consola >> Real [Lista posibles Valores]
    public static final double leerReal(String msgUsr, String msgErr, double lista[]) {
        // Número a Devolver
        double dato;

        // Semáforo Validación
        boolean datoOK;

        // Bucle Validación
        do {
            // Introducir Real
            dato = UtilesEntrada.leerReal(msgUsr, msgErr);

            // Validar Existencia Real
            datoOK = UtilesArrays.buscar(lista, dato) > -1;

            // Entero Inexistente >> Mensaje de error
            if (!datoOK) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Real [Lista posibles Valores]
    public static final double leerReal(String msgUsr, double lista[]) {
        return UtilesEntrada.leerReal(msgUsr, MSG_ERR, lista);
    }

    // Consola + Expresión Regular > Real
    public static final double leerReal(String msgUsr, String msgErr, String er) {
        // Referencia
        double dato = 0.0;

        // Bucle Validación
        boolean datoOK;
        do {
            // Consola > Dato
            dato = leerReal(msgUsr, msgErr);

            // Validar Dato
            datoOK = UtilesValidacion.validar(dato + "", er);

            // Procesar Validación
            if (!datoOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!datoOK);

        // Retorno
        return dato;
    }

    // Consola + Expresión Regular > Real
    public static final double leerReal(String msgUsr, String msgErr,
            String er, double sugerencia) {
        // Referencia
        double dato = 0.0;

        // Bucle Validación
        boolean datoOK;
        do {
            // Consola > Dato
            dato = leerReal(msgUsr, msgErr, sugerencia);

            // Validar Dato
            datoOK = UtilesValidacion.validar(dato + "", er);

            // Procesar Validación
            if (!datoOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!datoOK);

        // Retorno
        return dato;
    }

    // Consola >> Carácter
    public static final char leerCaracter(String msgUsr, String msgErr) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Carácter
    @SuppressWarnings({"SleepWhileInLoop", "UseSpecificCatch"})
    public static final char leerCaracter(String msgUsr, String msgErr,
            char sugerencia) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Mensaje de Usuario
                System.out.print(msgUsr);

                // Espera que se complete print - Código Basura
                Thread.sleep(400);

                // Texto > Portapapeles > Entrada - Código Basura
                UtilesPortapapeles.inyectar(sugerencia + "");

                // Entrada dato
                dato = SCN.nextLine().charAt(0);

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Carácter
    public static final char leerCaracter(String msgUsr) {
        return leerCaracter(msgUsr, MSG_ERR);
    }

    // Consola >> Carácter
    public static final char leerCaracter(String msgUsr, char sugerencia) {
        return leerCaracter(msgUsr, MSG_ERR, sugerencia);
    }

    // Opciones + Consola > Opcion
    public static final char leerCaracter(String msgUsr, String msgErr,
            String opciones) {
        char opcion;
        boolean opcionOK = false;
        do {
            opcion = leerCaracter(msgUsr, "");
            if (opciones.contains(opcion + "")) {
                opcionOK = true;
            } else {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!opcionOK);
        return opcion;
    }

    // Opciones + Consola > Opcion
    public static final char leerCaracter(String msgUsr, String msgErr,
            String opciones, char sugerencia) {
        char opcion;
        boolean opcionOK = false;
        do {
            opcion = leerCaracter(msgUsr, "", sugerencia);
            if (opciones.contains(opcion + "")) {
                opcionOK = true;
            } else {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!opcionOK);
        return opcion;
    }

    // Consola >> Carácter [min .. max]
    public static final char leerCaracter(String msgUsr, String msgErr,
            char min, char max) {
        // Dato a introducir
        char dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Caracter
            dato = leerCaracter(msgUsr, msgErr);

            // Validar Rango Caracter
            rangoOK = dato >= min && dato <= max;

            // Rango Caracter Erróneo >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver carácter
        return dato;
    }

    // Consola >> Carácter [min .. max]
    public static final char leerCaracter(String msgUsr, String msgErr,
            char min, char max, char sugerencia) {
        // Dato a introducir
        char dato;

        // Semáforo Validación
        boolean rangoOK;

        // Bucle Validación
        do {
            // Introducir Caracter
            dato = leerCaracter(msgUsr, msgErr, sugerencia);

            // Validar Rango Caracter
            rangoOK = dato >= min && dato <= max;

            // Rango Caracter Erróneo >> Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver carácter
        return dato;
    }

    // Consola >> Carácter [min .. max]
    public static final char leerCaracter(String msgUsr, char min, char max) {
        return leerCaracter(msgUsr, MSG_ERR, min, max);
    }

    // Consola >> Carácter [min .. max]
    public static final char leerCaracter(String msgUsr,
            char min, char max, char sugerencia) {
        return leerCaracter(msgUsr, MSG_ERR, min, max, sugerencia);
    }

    // Consola >> Texto
    public static final String leerTexto(String msgUsr) {
        // Mensaje de Usuario
        System.out.print(msgUsr);

        // Entrada de Texto
//        String txt = SCN.nextLine();
//        System.out.println(txt);
//        return txt;
        return SCN.nextLine();
    }

    // Consola >> Texto
    public static final String leerTexto(String msgUsr, String sugerencia) {
        // Mensaje de Usuario
        System.out.print(msgUsr);

        try {
            // Espera que se complete print - Código Basura
            Thread.sleep(400);

            // Texto > Portapapeles > Entrada - Código Basura
            UtilesPortapapeles.inyectar(sugerencia);
        } catch (InterruptedException ex) {
        }

        // Entrada de Texto
//        String txt = SCN.nextLine();
//        System.out.println(txt);
//        return txt;
        return SCN.nextLine();
    }

    // Consola + Expresión Regular > Texto
    public static final String leerTexto(String msgUsr, String msgErr,
            String er) {
        String txt = "";
        boolean dataOK;

        do {
            txt = leerTexto(msgUsr);
            System.out.println(txt);

            dataOK = UtilesValidacion.validar(txt, er);

            if (!dataOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dataOK);

        return txt;
    }

    // Consola + Expresión Regular > Texto
    public static final String leerTexto(String msgUsr, String msgErr,
            String er, String sugerencia) {
        String txt = "";
        boolean dataOK;

        do {
            txt = leerTexto(msgUsr, sugerencia);
            System.out.println(txt);

            dataOK = UtilesValidacion.validar(txt, er);

            if (!dataOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dataOK);

        return txt;
    }

    // Consola > Lógico
    public static final boolean leerLogico(String msgUsr, String msgErr) {
        // Valor de retorno
        boolean b = false;

        // Entrada de Valor
        boolean introOK = false;
        do {
            try {
                System.out.print(msgUsr);
                b = SCN.nextBoolean();
                introOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!introOK);

        // Retorno
        return b;
    }

    // Consola >> Calendar
    public static final Calendar leerDatoTemporal(String patron,
            Locale locale, String msgUsr, String msgErr,
            boolean modoEstrictoOK) {
        // Formateador
        SimpleDateFormat sdf = new SimpleDateFormat(patron, locale);

        // Referencia Calendar
        Calendar calendar = null;

        // Bucle Validación
        boolean datoOK = false;
        do {
            // Intro + Parse
            try {
                // Consola >> Dato (Texto)
                String texto = leerTexto(msgUsr);

                // Modo Estricto
                if (true
                        && !UtilesTemporales.validarFecha(texto)
                        && !UtilesTemporales.validarHora(texto)) {
                    throw new ParseException(msgErr, 0);
                }

                // Texto >> Date
                Date date = sdf.parse(texto);

                // Instancia Objeto Calendar
                calendar = Calendar.getInstance();

                // Date >> Calendar
                calendar.setTime(date);

                // Actualización Semáforo
                datoOK = true;
            } catch (ParseException e) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devuelve Calendar
        return calendar;
    }

    // Consola >> Calendar (Locale ESP)
    public static final Calendar leerDatoTemporal(String patron,
            String msgUsr, String msgErr, boolean modoEstrictoOK) {
        return leerDatoTemporal(patron, LCL_ESP, msgUsr, msgErr, modoEstrictoOK);
    }

    // Consola >> Fecha
    public static final Calendar leerFecha(String msgUsr, String msgErr) {
        return leerDatoTemporal(UtilesTemporales.FMT_DATE_ESP, msgUsr, msgErr, true);
    }

    // Consola >> Fecha
    public static final Calendar leerFecha(String msgUsr) {
        return leerFecha(msgUsr, MSG_ERR);
    }

    // Consola >> Hora
    public static final Calendar leerHora(String msgUsr, String msgErr) {
        return leerDatoTemporal(UtilesTemporales.FMT_HOUR_LONG, msgUsr, msgErr, true);
    }

    // Consola >> Hora
    public static final Calendar leerHora(String msgUsr) {
        return leerHora(msgUsr, MSG_ERR);
    }

    // Mensaje Personalizado + Pausa ( Intro )
    public static final void hacerPausa(String msg) {
        System.out.println(msg);
        hacerPausa();
    }

    // Pausa ( Intro )
    public static final void hacerPausa() {
        System.out.println("---");
        leerTexto(MSG_BRK);
        System.out.println("---");
    }

    // Confirmación S/N + Defecto > Boolean
    public static final boolean confirmarProceso(String msgUsr, boolean defectoOK) {
        // Semáforo
        boolean confirmacionOK = defectoOK;

        // Consola > Caracter
        String entrada = leerTexto(msgUsr);

        // Analisis Entrada
        if (entrada.length() > 0) {
            // Entrada > Caracter 1
            char c = entrada.charAt(0);

            // Caracter [Ss | Nn] > Boolean
            confirmacionOK = "Ss".contains(c + "");
        }

        // Devolución Confirmación
        return confirmacionOK;
    }
}
