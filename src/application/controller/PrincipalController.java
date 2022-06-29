package application.controller;

import application.model.Produto;
import application.model.ProdutoBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;

public class PrincipalController {

    @FXML private Button btnAdicionar;
    @FXML private Button btnExcluir;
    @FXML private Button btnListar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnProcurar;
    @FXML private TextField fieldCor;
    @FXML private TextField fieldId;
    @FXML private TextField fieldItem;
    @FXML private TextField fieldMarca;
    @FXML private TextField fieldModelo;
    @FXML private TextField fieldPreco;
    @FXML private Label labelCor;
    @FXML private Label labelId;
    @FXML private Label labelItem;
    @FXML private Label labelMarca;
    @FXML private Label labelModelo;
    @FXML private Label labelPreco;
    @FXML private TextArea textAreaList;


    @FXML void acaoProduto(ActionEvent event) {

        String cmd = event.getSource().toString();
        System.out.println(cmd);

        IInserirC ins = new SInserirC(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaList);
        IAtualizarC atl = new SAtualizarC(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaList);
        IExcluirC exc = new SExcluirC(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaList);
        IProcurarC pro = new SProcurarC(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco);
        IListarC lst = new SListarC(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaList);


        if ((cmd.contains("Adicionar") || cmd.contains("Atualizar"))
                && (fieldId.getText().isEmpty()
                || fieldItem.getText().isEmpty()
                || fieldMarca.getText().isEmpty()
                || fieldModelo.getText().isEmpty()
                || fieldCor.getText().isEmpty()
                || fieldPreco.getText().isEmpty()
                )) {
            JOptionPane.showMessageDialog(null,
                    "É necessário o preenchimento completo do produto *",
                    "Erro ao adicionar/atualizar", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmd.contains("Excluir")
                && (fieldId.getText().isEmpty()
                || fieldItem.getText().isEmpty()
                || fieldMarca.getText().isEmpty()
                || fieldModelo.getText().isEmpty()
                || fieldCor.getText().isEmpty()
                || fieldPreco.getText().isEmpty()
                )) {
            JOptionPane.showMessageDialog(null,
                    "É necessário os dados completos do produto para exclusão *",
                    "Erro ao excluir", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmd.contains("Procurar") && fieldItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "É necessário o preenchimento do campo 'item' para a busca *",
                    "Erro ao procurar", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmd.contains("Listar")) {
            lst.listar();

        } else {
            Produto p = ProdutoBuilder.builder()
                    .addId(fieldId.getText())
                    .addItem(fieldItem.getText().toUpperCase())
                    .addMarca(fieldMarca.getText().toUpperCase())
                    .addModelo(fieldModelo.getText().toUpperCase())
                    .addCor(fieldCor.getText().toUpperCase())
                    .addPreco(fieldPreco.getText())
                    .get();

            if (cmd.contains("Adicionar")) {
                ins.inserir(p);
            } else if (cmd.contains("Atualizar")) {
                atl.atualizar(p);
            } else if (cmd.contains("Excluir")) {
                exc.excluir(p);
            } else if (cmd.contains("Procurar")) {
                pro.procurar(p);
            }
        }
    }
}