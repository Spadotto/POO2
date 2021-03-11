package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.UsuarioDAO;

public class LoginController {
	
    @FXML
    private TextField cpfield;

    @FXML
    private PasswordField txtsenha;

    @FXML
    private Button login;

    @FXML
    private Button cadastrar;

    @FXML
    private Button sair;

    @FXML
    void ChamarCadastro(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
		stage.setScene(FXMLUtil.loadScene("cadastro"));
		stage.setResizable(false);
		stage.show();
    }

    @FXML
    void ChamarMain(ActionEvent event) throws IOException {
    	String cpf = cpfield.getText();
		String senha = txtsenha.getText();

		if (cpf.isBlank()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return;
		}
		if (senha.isBlank()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return;
		}
		Usuario user = new UsuarioDAO().get(cpf);
		if (user == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return;
		}
		if (!user.getSenha().contentEquals(senha)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return;
		}
		
		new UsuarioDAO().persist(user);
		App.setRoot("main");
		App.changeResizable();
		MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(user);
		
    }
    
    @FXML
    void Sair(ActionEvent event) throws IOException {
    	Platform.exit();
    }

}
