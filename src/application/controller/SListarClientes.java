package application.controller;

import application.model.Cliente;
import application.persistence.SSelectAllCliente;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

import java.util.List;

public class SListarClientes implements IListar<Cliente> {

    private TextField fieldNome;
    private TextField fieldCpf;
    private TextField fieldEndereco;
    private TextField fieldCep;
    private TextField fieldTelefone;
    private TextField fieldEmail;
    private TextArea textAreaListC;

    public SListarClientes(TextField fieldNome, TextField fieldCpf, TextField fieldEndereco, TextField fieldCep, TextField fieldTelefone, TextField fieldEmail, TextArea textAreaListC) {
        this.fieldNome = fieldNome;
        this.fieldCpf = fieldCpf;
        this.fieldEndereco = fieldEndereco;
        this.fieldCep = fieldCep;
        this.fieldTelefone = fieldTelefone;
        this.fieldEmail = fieldEmail;
        this.textAreaListC = textAreaListC;
    }

    @Override
    public List<Cliente> listar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SSelectAllCliente dao = new SSelectAllCliente(sf);

        SLimparCliente cl = new SLimparCliente(fieldNome, fieldCpf, fieldEndereco, fieldCep, fieldTelefone, fieldEmail);
        cl.limpar();

        List<Cliente> listaClientes = dao.selectAll();

        StringBuffer buffer = new StringBuffer("Nome:\t\t\t\tCPF:\t\t\t\tEndereco:\t\t\t\tCEP:\t\t\t\tTelefone:\t\t\t\tEmail:\n");
        for (Cliente c : listaClientes) {
            buffer.append(c.getNome() + "\t\t\t");
            buffer.append(c.getCpf() + "\t\t\t");
            buffer.append(c.getEndereco() + "\t\t\t");
            buffer.append(c.getCep() + "\t\t\t");
            buffer.append(c.getTelefone() + "\t\t\t");
            buffer.append(c.getEmail() + "\n");
        }
        textAreaListC.setText(buffer.toString());
        return listaClientes;
    }
}
