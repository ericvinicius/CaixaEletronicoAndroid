package com.br.faculdade.caixaeletrinicoandroid.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.br.faculdade.caixaeletrinicoandroid.ClienteControll;
import com.br.faculdade.caixaeletrinicoandroid.DataController;
import com.br.faculdade.caixaeletrinicoandroid.R;
import com.br.faculdade.caixaeletrinicoandroid.model.Cliente;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    TextView bemVindo;
    TextView saldo;
    Button botaoSacar;
    TextView editSacar;


    Button botaoTransferencia;
    private EditText editConta;
    private EditText editValor;
    private EditText editAgencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        bemVindo.setText(bemVindo.getText() + DataController.getClienteLogado().getNome() + "!");
        saldo.setText(DataController.getClienteLogado().getSaldo().toString());

        botaoSacar.setOnClickListener(new SacarAction());
        botaoTransferencia.setOnClickListener(new TransferenciaAction());
    }

    private class SacarAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            BigDecimal valor = new BigDecimal(editSacar.getText().toString());
            BigDecimal novoSaldo = DataController.getClienteLogado().getSaldo().subtract(valor);
            DataController.getClienteLogado().setSaldo(novoSaldo);

            saldo.setText(DataController.getClienteLogado().getSaldo().toString());
            editSacar.setText("");
        }
    }

    private class TransferenciaAction implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String agencia = editAgencia.getText().toString();
            String conta = editConta.getText().toString();
            BigDecimal valor = new BigDecimal(editValor.getText().toString());

            Cliente cliente = new ClienteControll(conta, agencia).getCliente();
            cliente.setSaldo(cliente.getSaldo().add(valor));

            BigDecimal novoSaldo = DataController.getClienteLogado().getSaldo().subtract(valor);
            DataController.getClienteLogado().setSaldo(novoSaldo);

            saldo.setText(novoSaldo.toString());
        }
    }



    private void loadViews() {
        botaoSacar = (Button) findViewById(R.id.button_sacar);
        bemVindo = (TextView) findViewById(R.id.text_bem_vindo);
        saldo = (TextView) findViewById(R.id.text_saldo);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        editSacar = (TextView) findViewById(R.id.edit_text_sacar);

        botaoTransferencia = (Button) findViewById(R.id.button_tranfenrencia);
        editConta = (EditText) findViewById(R.id.edit_text_tranferencia_conta);
        editValor = (EditText) findViewById(R.id.edit_text_tranferencia_valor);
        editAgencia = (EditText) findViewById(R.id.edit_text_tranferencia_agencia);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
