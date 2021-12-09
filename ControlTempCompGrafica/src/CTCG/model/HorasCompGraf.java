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
public class HorasCompGraf {
    
    // Atributos    
    private int cod_hcg;
    private int cadoperador;
    private int h;
    private int m;
    private String nomeoperador;
    private String ordemprod;
    private String obs;
    private String inicio;
    private String termino;
    private String criado;
    private String modificado;
    
    //Getters e Setters
    public int getCod_hcg() {
        return cod_hcg;
    }

    public void setCod_hcg(int cod_hcg) {
        this.cod_hcg = cod_hcg;
    }

    public int getCadoperador() {
        return cadoperador;
    }

    public void setCadoperador(int cadoperador) {
        this.cadoperador = cadoperador;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public String getNomeoperador() {
        return nomeoperador;
    }

    public void setNomeoperador(String nomeoperador) {
        this.nomeoperador = nomeoperador;
    }

    public String getOrdemprod() {
        return ordemprod;
    }

    public void setOrdemprod(String ordemprod) {
        this.ordemprod = ordemprod;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        this.criado = criado;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

}
