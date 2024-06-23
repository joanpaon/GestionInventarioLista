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

import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author José A. Pacheco - japolabs@gmail.com
 */
public final class Articulo {

    // Campos
    private Long idd;
    private String nom;
    private Double pre;
    private Integer sac;
    private Integer smi;

    // Contructor Predeterminado - Oculto
    public Articulo() {
        idd = UtilesArticulo.DEF_IDD;
        nom = UtilesArticulo.DEF_NOM;
        pre = UtilesArticulo.DEF_PRE;
        sac = UtilesArticulo.DEF_SAC;
        smi = UtilesArticulo.DEF_SMI;
    }

    // Constructor Parametrizado
    public Articulo(Long idd, String nom, Double pre,
            Integer sac, Integer smi) throws Exception {
        // Id
        if (UtilesArticulo.validarId(idd)) {
            this.idd = idd;
        } else {
            throw new Exception(UtilesArticulo.MSG_ERR_IDD);
        }

        // Nombre
        if (UtilesArticulo.validarNombre(nom)) {
            this.nom = nom;
        } else {
            throw new Exception(UtilesArticulo.MSG_ERR_NOM);
        }

        // Precio
        if (UtilesArticulo.validarPrecio(pre)) {
            this.pre = pre;
        } else {
            this.pre = UtilesArticulo.DEF_PRE;
        }

        // Stock Actual
        if (UtilesArticulo.validarStkAct(sac)) {
            this.sac = sac;
        } else {
            this.sac = UtilesArticulo.DEF_SAC;
        }

        // Stock Mínimo
        if (UtilesArticulo.validarStkMin(smi)) {
            this.smi = smi;
        } else {
            this.smi = UtilesArticulo.DEF_SMI;
        }
    }

    public Long getIdd() {
        return idd;
    }

    public void setIdd(Long idd) {
        if (UtilesArticulo.validarId(idd)) {
            this.idd = idd;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (UtilesArticulo.validarNombre(nom)) {
            this.nom = nom;
        }
    }

    public Double getPre() {
        return pre;
    }

    public void setPre(Double pre) {
        // Precio
        if (UtilesArticulo.validarPrecio(pre)) {
            this.pre = pre;
        }
    }

    public Integer getSac() {
        return sac;
    }

    public void setSac(Integer sac) {
        if (UtilesArticulo.validarStkAct(sac)) {
            this.sac = sac;
        }
    }

    public Integer getSmi() {
        return smi;
    }

    public void setSmi(Integer smi) {
        if (UtilesArticulo.validarStkMin(smi)) {
            this.smi = smi;
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH,
                "%5d %-30s %5.2f %2d %2d",
                idd, nom, pre,
                sac, smi);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Articulo a
                ? Objects.equals(this.idd, a.idd)
                && Objects.equals(this.nom, a.nom)
                && Objects.equals(this.pre, a.pre) : false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idd);
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.pre);
        return hash;
    }
}
