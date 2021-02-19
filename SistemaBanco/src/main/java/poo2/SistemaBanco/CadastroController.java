package poo2.SistemaBanco;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CadastroController {

    @FXML
    private Button cadastrar;

    @FXML
    private Button voltar;

    @FXML
    private Button sair;

    @FXML
    void CadastrarUsuário(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

    @FXML
    void Sair(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void VoltarLogin(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }

}
