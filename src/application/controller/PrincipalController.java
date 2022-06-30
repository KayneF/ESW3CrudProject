package application.controller;

import application.model.Cliente;
import application.model.ClienteBuilder;
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

    // Produto
    // ==============================================
    @FXML private Button btnAdicionarP;
    @FXML private Button btnExcluirP;
    @FXML private Button btnListarP;
    @FXML private Button btnAtualizarP;
    @FXML private Button btnProcurarP;
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
    @FXML private TextArea textAreaListP;


    // Cliente
    // ==============================================
    @FXML private Button btnAdicionarC;
    @FXML private Button btnExcluirC;
    @FXML private Button btnListarC;
    @FXML private Button btnAtualizarC;
    @FXML private Button btnProcurarC;
    @FXML private TextField fieldNome;
    @FXML private TextField fieldCpf;
    @FXML private TextField fieldEndereco;
    @FXML private TextField fieldCep;
    @FXML private TextField fieldTelefone;
    @FXML private TextField fieldEmail;
    @FXML private Label labelNome;
    @FXML private Label labelCpf;
    @FXML private Label labelEndereco;
    @FXML private Label labelCep;
    @FXML private Label labelTelefone;
    @FXML private Label labelEmail;
    @FXML private TextArea textAreaListC;


    // Action Produto
    // ==============================================
    @FXML void acaoProduto(ActionEvent event) {

        String cmdP = event.getSource().toString();
        System.out.println(cmdP);

        IInserir insP = new SInserirProduto(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaListP);
        IAtualizar atlP = new SAtualizarProduto(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaListP);
        IExcluir excP = new SExcluirProduto(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaListP);
        IProcurar proP = new SProcurarProduto(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco);
        IListar lstP = new SListarProdutos(fieldId, fieldItem, fieldMarca,
                fieldModelo, fieldCor, fieldPreco, textAreaListP);


        if ((cmdP.contains("Adicionar") || cmdP.contains("Atualizar"))
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

        else if (cmdP.contains("Excluir")
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

        else if (cmdP.contains("Procurar") && fieldItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "É necessário o preenchimento do campo 'item' para a busca *",
                    "Erro ao procurar", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmdP.contains("Listar")) {
            lstP.listar();

        } else {
            Produto p = ProdutoBuilder.builder()
                    .addId(fieldId.getText())
                    .addItem(fieldItem.getText().toUpperCase())
                    .addMarca(fieldMarca.getText().toUpperCase())
                    .addModelo(fieldModelo.getText().toUpperCase())
                    .addCor(fieldCor.getText().toUpperCase())
                    .addPreco(fieldPreco.getText())
                    .get();

            if (cmdP.contains("Adicionar")) {
                insP.inserir(p);
            } else if (cmdP.contains("Atualizar")) {
                atlP.atualizar(p);
            } else if (cmdP.contains("Excluir")) {
                excP.excluir(p);
            } else if (cmdP.contains("Procurar")) {
                proP.procurar(p);
            }
        }
    }


    // Action Cliente
    // ==============================================
    @FXML void acaoCliente(ActionEvent event) {

        String cmdC = event.getSource().toString();
        System.out.println(cmdC);

        IInserir insC = new SInserirCliente(fieldNome, fieldCpf, fieldEndereco,
                fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        IAtualizar atlC = new SAtualizarCliente(fieldNome, fieldCpf, fieldEndereco,
                fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        IExcluir excC = new SExcluirCliente(fieldNome, fieldCpf, fieldEndereco,
                fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        IProcurar proC = new SProcurarCliente(fieldNome, fieldCpf, fieldEndereco,
                fieldCep, fieldTelefone, fieldEmail, textAreaListC);
        IListar lstC = new SListarClientes(fieldNome, fieldCpf, fieldEndereco,
                fieldCep, fieldTelefone, fieldEmail, textAreaListC);


        if ((cmdC.contains("Adicionar") || cmdC.contains("Atualizar"))
                && (fieldNome.getText().isEmpty()
                || fieldCpf.getText().isEmpty()
                || fieldEndereco.getText().isEmpty()
                || fieldCep.getText().isEmpty()
                || fieldTelefone.getText().isEmpty()
                || fieldEmail.getText().isEmpty()
        )) {
            JOptionPane.showMessageDialog(null,
                    "É necessário o preenchimento completo do cliente *",
                    "Erro ao adicionar/atualizar", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmdC.contains("Excluir")
                && (fieldNome.getText().isEmpty()
                || fieldCpf.getText().isEmpty()
                || fieldEndereco.getText().isEmpty()
                || fieldCep.getText().isEmpty()
                || fieldTelefone.getText().isEmpty()
                || fieldEmail.getText().isEmpty()
        )) {
            JOptionPane.showMessageDialog(null,
                    "É necessário os dados completos do cliente para exclusão *",
                    "Erro ao excluir", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmdC.contains("Procurar") && fieldCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "É necessário o preenchimento do campo 'CPF' para a busca *",
                    "Erro ao procurar", JOptionPane.WARNING_MESSAGE);
        }

        else if (cmdC.contains("Listar")) {
            lstC.listar();

        } else {
            Cliente c = ClienteBuilder.builder()
                    .addNome(fieldNome.getText().toUpperCase())
                    .addCpf(fieldCpf.getText().toUpperCase())
                    .addEndereco(fieldEndereco.getText().toUpperCase())
                    .addCep(fieldCep.getText().toUpperCase())
                    .addTelefone(fieldTelefone.getText().toUpperCase())
                    .addEmail(fieldEmail.getText().toUpperCase())
                    .get();

            if (cmdC.contains("Adicionar")) {
                insC.inserir(c);
            } else if (cmdC.contains("Atualizar")) {
                atlC.atualizar(c);
            } else if (cmdC.contains("Excluir")) {
                excC.excluir(c);
            } else if (cmdC.contains("Procurar")) {
                proC.procurar(c);
            }
        }
    }
}