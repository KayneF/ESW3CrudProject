package application.controller;

import application.model.Produto;
import application.persistence.SSelectAllProduto;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

import java.util.List;

public class SListarProdutos implements IListar {

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;
    private TextArea textAreaList;

    public SListarProdutos(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco, TextArea textAreaList) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
        this.textAreaList = textAreaList;
    }

    @Override
    public List<Produto> listar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SSelectAllProduto dao = new SSelectAllProduto(sf);

        SLimparProduto l = new SLimparProduto(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco);
        l.limpar();

        List<Produto> listaProdutos = dao.selectAll();

        StringBuffer buffer = new StringBuffer("ID:\t\t\tItem:\t\t\tMarca:\t\t\tModelo:\t\t\tCor:\t\t\tPreço:\n");
        for (Produto p : listaProdutos) {
            buffer.append(p.getId() + "\t\t\t");
            buffer.append(p.getItem() + "\t\t\t");
            buffer.append(p.getMarca() + "\t\t\t");
            buffer.append(p.getModelo() + "\t\t\t");
            buffer.append(p.getCor() + "\t\t\t");
            buffer.append(p.getPreco() + "\n");
        }
        textAreaList.setText(buffer.toString());
        return listaProdutos;
    }
}
