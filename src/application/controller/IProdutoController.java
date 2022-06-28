package application.controller;

import application.model.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoController {

    void inserirProduto(Produto p) throws SQLException;
    void atualizarProduto(Produto p) throws SQLException;
    void excluirProduto(Produto p) throws SQLException;
    void procurarProduto(Produto p) throws SQLException;
    List<Produto> listarProdutos() throws SQLException;

}
