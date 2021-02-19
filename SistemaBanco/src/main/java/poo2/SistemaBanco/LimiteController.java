package poo2.SistemaBanco;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LimiteController {

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
    }
}