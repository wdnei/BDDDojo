/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd.calculos;

import java.math.BigDecimal;

/**
 *
 * @author admindev
 */
public abstract class CalcularINSS {

    protected BigDecimal LIMITE_FAIXA_1;
    protected BigDecimal referencia_faixa1;
    protected BigDecimal LIMITE_FAIXA_2;
    protected BigDecimal referencia_faixa2;
    protected BigDecimal LIMITE_FAIXA_3;
    protected BigDecimal referencia_faixa3;
    protected BigDecimal teto;

    public Double calcular(BigDecimal valorBase) {
        
        BigDecimal referencia_base = new BigDecimal(0);

        if (valorBase.compareTo(LIMITE_FAIXA_1) < 0) {
            referencia_base = referencia_faixa1;

        } else {

            if (valorBase.compareTo(LIMITE_FAIXA_2) < 0) {
                referencia_base = referencia_faixa2;

            } else {

                if (valorBase.compareTo(LIMITE_FAIXA_3) < 0) {
                    referencia_base = referencia_faixa3;

                } else {
                    //TETO
                    return LIMITE_FAIXA_3.multiply(referencia_faixa3).doubleValue();
                }

            }

        }
        
        return valorBase.multiply(referencia_base).doubleValue();

    }

}
