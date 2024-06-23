/*
 * Copyright 2023 José A. Pacheco - japolabs@gmail.com.
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
package org.japo.java.main;

import org.japo.java.app.App;

/**
 *
 * @author José A. Pacheco - japolabs@gmail.com
 */
public final class Main {

    // Clave de Acceso
    private static final String CLAVE = "JAPO-Omicron-0";

    // Constructor Predeterminado ( Oculto )
    private Main() {
    }

    // Punto de Entrada
    public static void main(String[] args) {
        if (validarAcceso(args)) {
            // Objeto Lógica de Negocio
            App app = new App();

            // Lanzar la lógica de negocio
            app.launchApp();
        } else {
            System.out.println("Acceso Denegado");
            System.out.println("Contacte con el Servicio Técnico");
            System.out.println("Gracias por su colaboración");
        }
    }

    // Validación Parámetros Ejecución
    private static boolean validarAcceso(String[] args) {
        // Referencia
        boolean testOK;

        // Validación
        try {
            testOK = args[0].equals(CLAVE);
        } catch (Exception e) {
            testOK = false;
        }

        // Retorno
        return testOK;
    }
}
