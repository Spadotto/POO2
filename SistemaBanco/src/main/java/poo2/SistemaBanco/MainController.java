package poo2.SistemaBanco;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class MainController {
	
	@FXML
    private CheckBox hidecontent;

    @FXML
    private Button configs;

    @FXML
    private Label fatura;

    @FXML
    private Button pagfatura;

    @FXML
    private Button limite;

    @FXML
    private Button cartao;

    @FXML
    private Button apagarcartao;
    
    @FXML
    private Button sair;

    @FXML
    void Deslogar(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }
    
    @FXML
    void AbrirConfigs(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Não foi possível abrir as configurações");
		alert.show();
    }
    
    @FXML
    void PagarFatura(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Não foi possível gerar boleto");
		alert.show();
    }
    
    @FXML
    void AjustarLimite(ActionEvent event) throws IOException {
    	App.setRoot("limite");
    }
    
    @FXML
    void CriarCartao(ActionEvent event) throws IOException {
    	App.setRoot("cartao");
    }

    @FXML
    void EsconderFatura(ActionEvent event) throws IOException {
    	if(hidecontent.isSelected() == true) {
    		fatura.setVisible(false);
    	}else {
    		fatura.setVisible(true);
    	}
    }
    
}
