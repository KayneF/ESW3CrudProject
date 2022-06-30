package application.controller;

import application.model.Cliente;
import application.persistence.SDeleteCliente;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SExcluirCliente implements IExcluir<Cliente> {

    private TextField fieldNome;
    private TextField fieldCpf;
    private TextField fieldEndereco;
    private TextField fieldCep;
    private TextField fieldTelefone;
    private TextField fieldEmail;
    private TextArea textAreaListC;

    public SExcluirCliente(TextField fieldNome, TextField fieldCpf, TextField fieldEndereco, TextField fieldCep, TextField fieldTelefone, TextField fieldEmail, TextArea textAreaListC) {
        this.fieldNome = fieldNome;
        this.fieldCpf = fieldCpf;
        this.fieldEndereco = fieldEndereco;
        this.fieldCep = fieldCep;
        this.fieldTelefone = fieldTelefone;
        this.fieldEmail = fieldEmail;
        this.textAreaListC = textAreaListC;
    }

    @Override
    public void excluir(Cliente c) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SDeleteCliente dao = new SDeleteCliente(sf);
        dao.delete(c);

        SLimparCliente cl = new SLimparCliente(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail);
        SListarClientes ls = new SListarClientes(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        cl.limpar();
        ls.listar();
    }
}
