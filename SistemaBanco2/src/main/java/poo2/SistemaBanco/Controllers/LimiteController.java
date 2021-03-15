package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Usuario;

public class LimiteController {
	
	private Usuario user;
	
	public void UserInfo(Usuario user) {
		this.user = user;
	}

	@FXML
    void AumentarLimite(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Não foi possível aumentar seu limite no momento");
		alert.show();
    }

    @FXML
    void VoltarMain(ActionEvent event) throws IOException {
    	App.setRoot("main");
    	MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(user);
    }
}