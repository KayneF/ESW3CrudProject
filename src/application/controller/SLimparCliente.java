package application.controller;

import javafx.scene.control.TextField;

public class SLimparCliente implements ILimpar {

    private TextField fieldNome;
    private TextField fieldCpf;
    private TextField fieldEndereco;
    private TextField fieldCep;
    private TextField fieldTelefone;
    private TextField fieldEmail;

    public SLimparCliente(TextField fieldNome, TextField fieldCpf, TextField fieldEndereco, TextField fieldCep, TextField fieldTelefone, TextField fieldEmail) {
        this.fieldNome = fieldNome;
        this.fieldCpf = fieldCpf;
        this.fieldEndereco = fieldEndereco;
        this.fieldCep = fieldCep;
        this.fieldTelefone = fieldTelefone;
        this.fieldEmail = fieldEmail;
    }

    public void limpar() {
        fieldNome.setText("");
        fieldCpf.setText("");
        fieldEndereco.setText("");
        fieldCep.setText("");
        fieldTelefone.setText("");
        fieldEmail.setText("");
    }
}
