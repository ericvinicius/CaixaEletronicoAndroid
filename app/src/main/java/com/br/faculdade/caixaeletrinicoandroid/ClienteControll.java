package com.br.faculdade.caixaeletrinicoandroid;

import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

/**
 * Created by eric on 12/09/16.
 */
public class ClienteControll {
    private static String conta;
    private static String agencia;
    private static String senha;

    public static Cliente getCliente(String conta, String agencia) {
        ClienteControll.conta = conta;
        ClienteControll.agencia = agencia;
        return getCliente();
    }

    public static Cliente getCliente(String conta, String agencia, String senha){
        ClienteControll.conta = conta;
        ClienteControll.agencia = agencia;
        ClienteControll.senha = senha;
        return getCliente();
    }

    private static Cliente getCliente() {
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

    public Cliente getClienteRemote() {

        return null;
    }
}
