package com.br.faculdade.caixaeletrinicoandroid;

import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 05/09/16.
 */
public class DataController {

    private static Cliente cliente01 = new Cliente("Pansutti", "20", new BigDecimal("1000"), "20", "20");
    private static Cliente cliente02 = new Cliente("Eric", "10",new BigDecimal("1000"), "10", "10");
    private static Cliente cliente03 = new Cliente("Juan", "juan", new BigDecimal("1000"), "10003", "0002");
    private static List<Cliente> clientes = Arrays.asList(cliente01, cliente02, cliente03);

    private static Cliente clienteLogado = null;


    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void setClienteLogado(Cliente clienteLogado) {
        DataController.clienteLogado = clienteLogado;
    }

    public static void saca(BigDecimal valor) {
        BigDecimal novoSaldo = DataController.getClienteLogado().getSaldo().subtract(valor);
        DataController.getClienteLogado().setSaldo(novoSaldo);
    }

    public static void transferePara(BigDecimal valor, String agencia, String conta) {
        Cliente clienteBeneficiado = ClienteControll.getCliente(agencia, conta);
        BigDecimal saldo = clienteBeneficiado.getSaldo();
        clienteBeneficiado.setSaldo(saldo.add(valor));

        Cliente clienteLogado = getClienteLogado();
        clienteLogado.setSaldo(clienteLogado.getSaldo().subtract(valor));
    }
}
