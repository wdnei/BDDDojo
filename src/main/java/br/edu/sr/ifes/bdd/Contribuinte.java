/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sr.ifes.bdd;

/**
 *
 * @author admindev
 */
public class Contribuinte {

    private double salario;
    private int qtdDependentes;
    private double pensao;
    private double inss;

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the qtdDependentes
     */
    public int getQtdDependentes() {
        return qtdDependentes;
    }

    /**
     * @param qtdDependentes the qtdDependentes to set
     */
    public void setQtdDependentes(int qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    /**
     * @return the pensao
     */
    public double getPensao() {
        return pensao;
    }

    /**
     * @param pensao the pensao to set
     */
    public void setPensao(double pensao) {
        this.pensao = pensao;
    }

    /**
     * @return the inss
     */
    public double getInss() {
        return inss;
    }

    /**
     * @param inss the inss to set
     */
    public void setInss(double inss) {
        this.inss = inss;
    }

}
