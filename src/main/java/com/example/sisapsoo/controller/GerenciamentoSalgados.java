package com.example.sisapsoo.controller;


import com.example.sisapsoo.model.Salgado;
import com.example.sisapsoo.model.dao.SalgadoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciamentoSalgados implements Initializable {
    private SalgadoDAO sDAO = new SalgadoDAO();

    @FXML
    private BorderPane borderPanel;

    @FXML
    private Button buttonVoltar;

    @FXML
    private TableColumn<Salgado, Integer> idSalgado;

    @FXML
    private TableColumn<Salgado, String> nome;

    @FXML
    private Label labelTitulo;

    @FXML
    private Pane mainPanel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TableColumn<Salgado, Double> preco;

    @FXML
    private TableView<Salgado> tabelaSalgado;

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

    @FXML
    void voltarHome(ActionEvent event) {
        trocarCena(event, "/com/example/sisapsoo/home-view.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<Salgado> salgados = FXCollections.observableArrayList(sDAO.findAll());

        idSalgado.setCellValueFactory(new PropertyValueFactory<>("idSalgado"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tabelaSalgado.setItems(salgados);
    }
}
