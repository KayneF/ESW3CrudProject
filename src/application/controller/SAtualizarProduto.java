package application.controller;

import application.model.Produto;
import application.persistence.SUpdateProduto;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SAtualizarProduto implements IAtualizar<Produto> {

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;
    private TextArea textAreaListP;

    public SAtualizarProduto(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco, TextArea textAreaList) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
        this.textAreaListP = textAreaList;
    }

    @Override
    public void atualizar(Produto produto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SUpdateProduto dao = new SUpdateProduto(sf);
        dao.update(produto);

        SLimparProduto cl = new SLimparProduto(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco);
        SListarProdutos ls = new SListarProdutos(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco, textAreaListP);
        cl.limpar();
        ls.listar();
    }
}
