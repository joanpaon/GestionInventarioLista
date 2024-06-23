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

import java.util.Random;

/**
 *
 * @author José A. Pacheco - japolabs@gmail.com
 */
public final class UtilesAleatorios {

    // Sistema Datos Aleatorios
    public static final Random RND = new Random();

    // Constructor Inaccesible
    private UtilesAleatorios() {
    }

    // > Entero [min .. max] !
    public static final int generarEntero(int min, int max) {
        return RND.nextInt(max - min + 1) + min;
    }

    // > Caracter [min .. max] !
    public static final char generarCaracter(char min, char max) {
        return (char) (RND.nextInt(max - min + 1) + min);
    }

    // > Real [min .. max] !
    public static final double generarReal(double min, double max) {
        return RND.nextDouble() * (max - min) + min;
    }
}
