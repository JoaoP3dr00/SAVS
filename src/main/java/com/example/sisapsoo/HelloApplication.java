package com.example.sisapsoo;

import com.example.sisapsoo.controller.CadastroFuncController;
import com.example.sisapsoo.controller.GerenciamentoFuncs;
import com.example.sisapsoo.controller.LoginController;
// import com.example.sisapsoo.model.Gerente;
// import com.example.sisapsoo.model.dao.GerenteDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("Salgado Smart");

//        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/images/coxinha.png")));
//        stage.getIcons().add(icon);

        // Gerente g = new Gerente();
        // GerenteDAO gDAO = new GerenteDAO();

        // g.setId("4");
        // g.setSenha("1234");
        // g.setNome("jose");
        // g.setCpf("11");
        // g.setTelefone("2333");
        // g.setSalario(98.0);
        // gDAO.save(g);

//        LoginController controller = fxmlLoader.getController();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
