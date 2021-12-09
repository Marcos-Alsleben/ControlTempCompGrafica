/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCG.model;

/**
 *
 * @author usuario
 */
public class Operador {
    
    // Atributos    
    private int cod_oper;
    private int cadastro;
    private String nome;
    
    //Getters e Setters

    public int getCod_oper() {
        return cod_oper;
    }

    public void setCod_oper(int cod_oper) {
        this.cod_oper = cod_oper;
    }

    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
