package com.br.faculdade.caixaeletrinicoandroid.HTTP;

/**
 * Created by eric on 22/10/16.
 */
public class Parameter {

    private String chave;
    private String valor;

    public Parameter(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

