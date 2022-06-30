package application.controller;

import application.model.Cliente;
import application.persistence.SSelectOneCliente;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SProcurarCliente implements IProcurar<Cliente> {

    private TextField fieldNome;
    private TextField fieldCpf;
    private TextField fieldEndereco;
    private TextField fieldCep;
    private TextField fieldTelefone;
    private TextField fieldEmail;
    private TextArea textAreaListC;

    public SProcurarCliente(TextField fieldNome, TextField fieldCpf, TextField fieldEndereco, TextField fieldCep, TextField fieldTelefone, TextField fieldEmail, TextArea textAreaListC) {
        this.fieldNome = fieldNome;
        this.fieldCpf = fieldCpf;
        this.fieldEndereco = fieldEndereco;
        this.fieldCep = fieldCep;
        this.fieldTelefone = fieldTelefone;
        this.fieldEmail = fieldEmail;
        this.textAreaListC = textAreaListC;
    }

    @Override
    public void procurar(Cliente c) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SSelectOneCliente dao = new SSelectOneCliente(sf);
        dao.selectOne(c);

        SLimparCliente cl = new SLimparCliente(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail);
        SListarClientes ls = new SListarClientes(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        cl.limpar();
        ls.listar();
    }
}
