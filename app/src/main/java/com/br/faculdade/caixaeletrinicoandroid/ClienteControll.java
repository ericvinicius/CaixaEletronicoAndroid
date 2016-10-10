package com.br.faculdade.caixaeletrinicoandroid;

import android.provider.ContactsContract;

import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

/**
 * Created by eric on 12/09/16.
 */
public class ClienteControll {
    private String conta;
    private String agencia;
    private String senha;

    public ClienteControll(String conta, String agencia, String senha) {
        this.conta = conta;
        this.agencia = agencia;
        this.senha = senha;
    }

    public ClienteControll(String conta, String agencia) {
        this.conta = conta;
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        for(Cliente cliente : DataController.getClientes()){
            if(cliente.getConta().equals(conta) && cliente.getAgencia().equals(agencia)){
                if(senha != null && cliente.getSenha().equals(senha)){
                    DataController.setClienteLogado(cliente);
                }
                return cliente;
            }
        }
        return null;
    }
}
