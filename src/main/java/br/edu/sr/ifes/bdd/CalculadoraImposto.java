/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd;

import br.edu.sr.ifes.bdd.calculos.CalcularINSS;
import br.edu.sr.ifes.bdd.calculos.CalcularIRPF;
import java.math.BigDecimal;

/**
 *
 * @author admindev
 */
public class CalculadoraImposto {

    CalcularINSS calcINSS;

    CalcularIRPF calcIRPF;

    public CalculadoraImposto(CalcularINSS calcINSS, CalcularIRPF calcIRPF) {
        this.calcINSS = calcINSS;
        this.calcIRPF = calcIRPF;
    }

    public double calcularIRPF(Contribuinte contribuinte) {
        contribuinte.setInss(calcINSS.calcular(new BigDecimal(contribuinte.getSalario())));
        return calcIRPF.calcularIRRF(contribuinte);

    }

    public double calcularINSS(Contribuinte contribuinte) {
        
        return calcINSS.calcular(new BigDecimal(contribuinte.getSalario()));

    }

}
