package application.controller;

import application.model.Produto;
import application.persistence.SSelectOneProduto;
import application.util.HibernateUtil;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SProcurarProduto implements IProcurar<Produto> {

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;

    public SProcurarProduto(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
    }

    @Override
    public void procurar(Produto produto) {
        SLimparProduto cl = new SLimparProduto(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SSelectOneProduto dao = new SSelectOneProduto(sf);
        cl.limpar();
        Produto p = dao.selectOne(produto);

        fieldId.setText(p.getId());
        fieldItem.setText(p.getItem());
        fieldMarca.setText(p.getMarca());
        fieldModelo.setText(p.getModelo());
        fieldCor.setText(p.getCor());
        fieldPreco.setText(p.getPreco());
    }
}
