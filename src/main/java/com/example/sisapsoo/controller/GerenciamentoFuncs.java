package com.example.sisapsoo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.sisapsoo.model.Funcionario;
import com.example.sisapsoo.model.dao.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GerenciamentoFuncs implements Initializable {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @FXML
    private BorderPane borderPanel;
    @FXML
    private Label labelTitulo;
    @FXML
    private Pane mainPanel;
    @FXML
    private MenuBar menuBar;
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, String> nome;
    @FXML
    private TableColumn<Funcionario, String> cpf;
    @FXML
    private TableColumn<Funcionario, String> salario;
    @FXML
    private TableColumn<Funcionario, String> telefone;
    @FXML
    private TableColumn<Funcionario, Integer> id;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Pane painelDeCima;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(funcionarioDAO.findAll());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabela.setItems(funcionarios);
    }

    @FXML
    void adicionar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/sisapsoo/add-func-dialog.fxml"));
            DialogPane dialogPane = fxmlLoader.load();

            CadastroFuncController cadastroFuncionarioController = fxmlLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("Cadastrar Funcionário");

            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.get() == ButtonType.OK) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void remover(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/sisapsoo/delete-func-dialog.fxml"));
            DialogPane funcionarioDialogPane = fxmlLoader.load();

            DeleteFuncionarioController deleteFuncionarioController = fxmlLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(funcionarioDialogPane);
            dialog.setTitle("Deletar Funcionário");

            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.get() == ButtonType.OK) {
                deleteFuncionarioController.remover(); // Executa remoção
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        trocarCena(event, "/com/example/sisapsoo/home-view.fxml");
    }

    private void trocarCena(ActionEvent event, String fxml) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, "Erro ao carregar a cena: " + fxml, e);
        }
    }
}