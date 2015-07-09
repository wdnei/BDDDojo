/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd.calculos;

import br.edu.sr.ifes.bdd.Contribuinte;
import java.math.BigDecimal;

/**
 *
 * @author admindev
 */
public abstract class CalcularIRPF {

    protected BigDecimal LIMITE_ISENTO;
    protected BigDecimal LIMITE_FAIXA_1;
    protected BigDecimal aliquota_faixa1;
    protected BigDecimal deducao_faixa1;
    protected BigDecimal LIMITE_FAIXA_2;
    protected BigDecimal aliquota_faixa2;
    protected BigDecimal deducao_faixa2;
    protected BigDecimal LIMITE_FAIXA_3;
    protected BigDecimal aliquota_faixa3;
    protected BigDecimal deducao_faixa3;
    protected BigDecimal LIMITE_FAIXA_4;
    protected BigDecimal aliquota_faixa4;
    protected BigDecimal deducao_faixa4;
    protected BigDecimal deducao_dependente;

    private BigDecimal obterBaseCalculo(Contribuinte contribuinte) {

        BigDecimal base = new BigDecimal(contribuinte.getSalario());

        BigDecimal dependentes = new BigDecimal(contribuinte.getQtdDependentes());
        dependentes = dependentes.multiply(deducao_dependente);
        base = base.subtract(dependentes);
        base = base.subtract(new BigDecimal(contribuinte.getInss()));
        
        base = base.subtract(new BigDecimal(contribuinte.getPensao()));

        return base;

    }

    public double calcularIRRF(Contribuinte contribuinte) {
        BigDecimal base = this.obterBaseCalculo(contribuinte);
        BigDecimal aliquotabase = null;
        BigDecimal deducaobase = null;

        if (base.compareTo(LIMITE_ISENTO) < 0) {
            return new Double(0.0);

        } else {

            if (base.compareTo(LIMITE_FAIXA_1) < 0) {
                aliquotabase = aliquota_faixa1;
                deducaobase = deducao_faixa1;

            } else {

                if (base.compareTo(LIMITE_FAIXA_2) < 0) {
                    aliquotabase = aliquota_faixa2;
                    deducaobase = deducao_faixa2;

                } else {

                    if (base.compareTo(LIMITE_FAIXA_3) < 0) {
                        aliquotabase = aliquota_faixa3;
                        deducaobase = deducao_faixa3;
                    } else {
                        aliquotabase = aliquota_faixa4;
                        deducaobase = deducao_faixa4;
                    }

                }

            }

        }

        return calculoIRRF(base, deducaobase, aliquotabase);
    }

    private Double calculoIRRF(BigDecimal valorBase, BigDecimal deducao, BigDecimal aliquota) {
        valorBase = valorBase.multiply(aliquota);
        valorBase = valorBase.subtract(deducao);
        
        return valorBase.doubleValue();
    }
}
