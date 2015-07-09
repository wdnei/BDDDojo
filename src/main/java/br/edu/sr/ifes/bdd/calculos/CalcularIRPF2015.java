/*
 * To change super license header, choose License Headers in Project Properties.
 * To change super template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd.calculos;

import java.math.BigDecimal;

/**
 *
 * @author admindev
 */


public class CalcularIRPF2015  extends CalcularIRPF{
    

    public CalcularIRPF2015() {
        super.LIMITE_ISENTO = new BigDecimal(1903.98);
        super.LIMITE_FAIXA_1 = new BigDecimal(2826.65);
        super.aliquota_faixa1 = new BigDecimal(0.075);
        super.deducao_faixa1 = new BigDecimal(142.80);
        super.LIMITE_FAIXA_2 = new BigDecimal(3751.05);
        super.aliquota_faixa2 = new BigDecimal(0.15);
        super.deducao_faixa2 = new BigDecimal(354.80);
        super.LIMITE_FAIXA_3 = new BigDecimal(4664.68);
        super.aliquota_faixa3 = new BigDecimal(0.225);
        super.deducao_faixa3 = new BigDecimal(636.13);
        
        super.aliquota_faixa4 = new BigDecimal(0.275);
        super.deducao_faixa4 = new BigDecimal(869.36);
        super.deducao_dependente=new BigDecimal(189.59);
        
    }
    
    
}
