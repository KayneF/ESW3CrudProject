package application.controller;

import application.model.Produto;
import application.persistence.SDelete;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SExcluirC implements IExcluirC {

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;
    private TextArea textAreaList;

    public SExcluirC(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco, TextArea textAreaList) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
        this.textAreaList = textAreaList;
    }

    @Override
    public void excluir(Produto produto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SDelete dao = new SDelete(sf);
        dao.delete(produto);

        SLimparC cl = new SLimparC(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco);
        SListarC ls = new SListarC(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco, textAreaList);
        cl.limpar();
        ls.listar();
    }
}
