package poo2.SistemaBanco.Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Usuario;
import javafx.scene.control.Alert.AlertType;

public class CartaoController {
	
	private Usuario c;
	
	@FXML
	private Label lblcartao;
	
	@FXML
    private Label txtnome;

    @FXML
    private Label txtsobrenome;

    @FXML
    private Label txtdatavenc;

    @FXML
    private Label txtcvv;
	
	@FXML
	private Button apagar;

	@FXML
	private Button voltar;

	
	@FXML
	void VoltarMain() throws IOException {
		App.setRoot("main");
		MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(c);
	}
	
	@FXML
    void ApagarCartao(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Não foi possível excluir cartão");
		alert.show();
    }
	
	void setNumConta(Cartao d) {
		//updateLibrary();
		lblcartao.setText(d.getNumCartao());
		txtdatavenc.setText(d.getDatavenc());
		txtcvv.setText(d.getCvv());
	}

	public void setDados(Usuario c) {
		this.c = c;
		txtnome.setText(c.getNome());
		txtsobrenome.setText(c.getSobrenome());
	}

}
