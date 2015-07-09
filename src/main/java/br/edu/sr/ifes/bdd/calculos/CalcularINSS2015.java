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
public class CalcularINSS2015 extends CalcularINSS {

    public CalcularINSS2015() {
        super.LIMITE_FAIXA_1=new BigDecimal(1399.12);
        super.referencia_faixa1=new BigDecimal(0.08);
        super.LIMITE_FAIXA_2=new BigDecimal(2331.88);
        super.referencia_faixa2=new BigDecimal(0.09);
        super.LIMITE_FAIXA_3=new BigDecimal(4663.75);
        super.referencia_faixa3=new BigDecimal(0.11);

    }

}
