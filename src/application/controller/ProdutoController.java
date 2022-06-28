package application.controller;

import application.model.Produto;
import application.persistence.ProdutoDao;
import application.util.HibernateUtil;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ProdutoController implements IProdutoController{

    SessionFactory sf = HibernateUtil.getSessionFactory();
    ProdutoDao produtoDao = new ProdutoDao(sf);

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;
    private TextArea textAreaList;

    public ProdutoController(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco, TextArea textAreaList) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
        this.textAreaList = textAreaList;
    }

    @Override
    public void inserirProduto(Produto produto) throws SQLException {
        produtoDao.create(produto);
        limpar();
        listarProdutos();
    }

    @Override
    public void atualizarProduto(Produto produto) throws SQLException{
        produtoDao.update(produto);
        limpar();
        listarProdutos();
    }

    @Override
    public void excluirProduto(Produto produto) throws SQLException{
        produtoDao.delete(produto);
        limpar();
        listarProdutos();
    }

    @Override
    public Produto procurarProduto(Produto produto) throws SQLException{
        limpar();
        Produto p = produtoDao.selectOne(produto);

        fieldId.setText(String.valueOf(p.getId()));
        fieldItem.setText(p.getItem());
        fieldMarca.setText(p.getMarca());
        fieldModelo.setText(p.getModelo());
        fieldCor.setText(p.getCor());
        fieldPreco.setText(String.valueOf(p.getPreco()));

        return p;
    }

    @Override
    public List<Produto> listarProdutos() throws SQLException {
        limpar();
        List<Produto> listaProdutos = produtoDao.selectAll();

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

    private void limpar() {
        fieldId.setText("");
        fieldItem.setText("");
        fieldMarca.setText("");
        fieldModelo.setText("");
        fieldCor.setText("");
        fieldPreco.setText("");
    }
}
