package poo2.SistemaBanco;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
    @FXML
    private TextField cpfield;

    @FXML
    private PasswordField senha;

    @FXML
    private Button login;

    @FXML
    private Button cadastrar;

    @FXML
    private Button sair;

    @FXML
    void ChamarCadastro(ActionEvent event) throws IOException {
    	App.setRoot("cadastro");
    }

    @FXML
    void ChamarMain(ActionEvent event) throws IOException {
    	App.setRoot("main");
    }
    
    @FXML
    void Sair(ActionEvent event) throws IOException {
    	Platform.exit();
    }

}
