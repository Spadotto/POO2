package poo2.SistemaBanco;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CartaoController {
	
	 @FXML
	    private Button apagar;

	 @FXML
	    private Button voltar;
	
	@FXML
	void VoltarMain() throws IOException {
		App.setRoot("main");
	}
	
	@FXML
    void ApagarCartao(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Não foi possível excluir cartão");
		alert.show();
    }

}
