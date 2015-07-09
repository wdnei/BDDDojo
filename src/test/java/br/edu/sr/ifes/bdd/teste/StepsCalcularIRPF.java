/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd.teste;

import br.edu.sr.ifes.bdd.CalculadoraImposto;
import br.edu.sr.ifes.bdd.Contribuinte;
import br.edu.sr.ifes.bdd.calculos.CalcularINSS2015;
import br.edu.sr.ifes.bdd.calculos.CalcularIRPF2015;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Assert;

/**
 *
 * @author 20101bsi0020
 */
public class StepsCalcularIRPF {

    private CalculadoraImposto calculadora;
    private Contribuinte contribuinte;
    
    
    public double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

    private Double ajusteRegexDouble(int arg1, int arg2) {
        
        String texto = "";
        if(arg2<10)
            texto=arg1 + ".0" + arg2;
        else
            texto=arg1 + "." + arg2;
        Double valor = new Double(texto);
        return valor;
    }

    @Dado("^Eu recebo R\\$ (\\d+),(\\d+) de salario$")
    public void euReceboR$DeSalario(int arg1, int arg2) {
        this.calculadora = new CalculadoraImposto(new CalcularINSS2015(),new CalcularIRPF2015());
        this.contribuinte = new Contribuinte();
        this.contribuinte.setSalario(ajusteRegexDouble(arg1, arg2));
    }

    @Dado("^Eu possuo (\\d+) dependente$")
    public void euPossuoDependente(int qtdDependentes) {
        this.contribuinte.setQtdDependentes(qtdDependentes);
    }

    @Dado("^Eu pago R\\$ (\\d+),(\\d+) de INSS$")
    public void euPagoR$DeINSS(int arg1, int arg2) {
        Double inss = ajusteRegexDouble(arg1, arg2);
        this.contribuinte.setInss(inss);
    }

    @Dado("^Eu pago R\\$ (\\d+),(\\d+) de pensao$")
    public void euPagoR$DePensao(int arg1, int arg2) {
        Double pensao = ajusteRegexDouble(arg1, arg2);
        this.contribuinte.setPensao(pensao);
    }

    @Entao("^Eu devo pagar R\\$ (\\d+),(\\d+) de imposto$")
    public void euDevoPagarR$DeImposto(int arg1, int arg2) {
        Double esperado = ajusteRegexDouble(arg1, arg2);
        Double atual = calculadora.calcularIRPF(contribuinte);
        Assert.assertEquals(esperado.doubleValue(), this.round(atual.doubleValue(),2), 0.01);
    }
    
    @Entao("^Eu devo pagar  R\\$ (\\d+),(\\d+) de INSS$")
public void euDevoPagarR$DeINSS(int arg1, int arg2) throws Throwable {
    Double esperado = ajusteRegexDouble(arg1, arg2);
        Double atual = calculadora.calcularINSS(contribuinte);
        Assert.assertEquals(esperado.doubleValue(), this.round(atual.doubleValue(),2), 0.01);
}

@Entao("^Eu devo pagar R\\$ (\\d+),(\\d+) de IRPF$")
public void euDevoPagarR$DeIRPF(int arg1, int arg2) throws Throwable {
    Double esperado = ajusteRegexDouble(arg1, arg2);
        Double atual = calculadora.calcularIRPF(contribuinte);
        Assert.assertEquals(esperado.doubleValue(), this.round(atual.doubleValue(),2), 0.01);
}
    
}

// "pt": {
//    "but": "*|Mas",
//    "and": "*|E",
//    "then": "*|Então|Entao",
//    "when": "*|Quando",
//    "name": "Portuguese",
//    "native": "português",
//    "background": "Contexto|Cenário de Fundo|Cenario de Fundo|Fundo",
//    "feature": "Funcionalidade|Característica|Caracteristica",
//    "scenario": "Cenário|Cenario",
//    "scenario_outline": "Esquema do Cenário|Esquema do Cenario|Delineação do Cenário|Delineacao do Cenario",
//    "examples": "Exemplos|Cenários|Cenarios",
//    "given": "*|Dado|Dada|Dados|Dadas"
//  }
