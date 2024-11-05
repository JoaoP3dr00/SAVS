package com.example.sisapsoo.controller;

import com.example.sisapsoo.model.Funcionario;
import com.example.sisapsoo.model.dao.FuncionarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class AdicionaFuncionarioController {

    private GerenciamentoFuncs gerenciamentoFuncs;
    private FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario;

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;
    @FXML
    private TextField campoSalario;
    @FXML
    private TextField campoTelefone;

    @FXML
    void reiniciar(ActionEvent event) {
        campoNome.clear();
        campoTelefone.clear();
        campoCpf.clear();
        campoSalario.clear();

        campoNome.setDisable(false);
        campoTelefone.setDisable(false);
        campoCpf.setDisable(false);
        campoSalario.setDisable(false);

        return;
    }

    @FXML
    void salvar(ActionEvent event) {
        funcionario = new Funcionario();
        funcionarioDAO = new FuncionarioDAO();

        // Verifica se todos os campos estão preenchidos
        if(campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()){
            showAlert("Campos vazios!", "Não deixe nenhum campo vazio.");
            return;
        }

        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();

        try {
            funcionario.setNome(nome);
            funcionario.setTelefone(telefone);

            funcionarioDAO.save(funcionario);

            campoNome.setDisable(true);
            campoTelefone.setDisable(true);
        }catch(Exception e){
            showAlert("Erro ao cadastrar: ", "" + e);
        }
        return;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
