package application.controller;

import application.model.Cliente;
import application.persistence.SCreateCliente;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SInserirCliente implements IInserir<Cliente> {

    private TextField fieldNome;
    private TextField fieldCpf;
    private TextField fieldEndereco;
    private TextField fieldCep;
    private TextField fieldTelefone;
    private TextField fieldEmail;
    private TextArea textAreaListC;

    public SInserirCliente(TextField fieldNome, TextField fieldCpf, TextField fieldEndereco, TextField fieldCep, TextField fieldTelefone, TextField fieldEmail, TextArea textAreaListC) {
        this.fieldNome = fieldNome;
        this.fieldCpf = fieldCpf;
        this.fieldEndereco = fieldEndereco;
        this.fieldCep = fieldCep;
        this.fieldTelefone = fieldTelefone;
        this.fieldEmail = fieldEmail;
        this.textAreaListC = textAreaListC;
    }

    @Override
    public void inserir(Cliente c) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SCreateCliente dao = new SCreateCliente(sf);
        dao.create(c);

        SLimparCliente cl = new SLimparCliente(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail);
        SListarClientes ls = new SListarClientes(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        cl.limpar();
        ls.listar();
    }
}
