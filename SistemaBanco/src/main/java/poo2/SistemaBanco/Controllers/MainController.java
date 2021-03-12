package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Usuario;

public class MainController {
	
	private Usuario user;
	private Usuario c;
	private Cartao d;
	
	@FXML
    private CheckBox hidecontent;

    @FXML
    private Button configs;

    @FXML
    private Label fatura;
    
    @FXML
    private Label saldorestante;
    
    @FXML
    private Label confidence;
    
    @FXML
    private Label lblUsuario;

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
    private Button convenio;

    @FXML
    void Deslogar(ActionEvent event) throws IOException {
    	App.setRoot("login");
    }
    
    @FXML
    void ChamarConvenio(ActionEvent event) throws IOException {
		App.setRoot("convenio");
		ConvController controller = FXMLUtil.getConvController();
		controller.UpdateConvs(user);
    }
    
    @FXML
    void AbrirConfigs(ActionEvent event) throws IOException {
    	App.setRoot("configs");
    	ConfigController controller = FXMLUtil.getConfigController();
		controller.UserInfo(c);
    }
    
    @FXML
    void PagarFatura(ActionEvent event) throws IOException {
    	Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Não foi possível gerar boleto!");
		alert.show();
    }
    
    @FXML
    void AjustarLimite(ActionEvent event) throws IOException {
    	App.setRoot("limite");
    	LimiteController controller = FXMLUtil.getLimiteController();
		controller.UserInfo(user);
    }
    
    @FXML
    void CriarCartao(ActionEvent event) throws IOException {
    	if(user.getCartao().getNumCartao().isEmpty()) {
    		Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Não foi possível gerar boleto!");
    		alert.show();
    	}else {
    		App.setRoot("cartao");
			CartaoController controller = FXMLUtil.getCartaoController();
			controller.setNumConta(d);
			controller.setDados(c);
    	}
		
    }

    @FXML
    void EsconderFatura(ActionEvent event) throws IOException {
    	if(hidecontent.isSelected() == true) {
    		fatura.setVisible(false);
    	}else {
    		fatura.setVisible(true);
    	}
    }
    
    public void UserInfo(Usuario u) {
    	this.user = u;
    	lblUsuario.setText(user.getNome());
		confidence.setText(user.getCpf());
		c = user;
		d = user.getCartao();
		String number = String.format("%.2f", d.getSaldo());
		String number2 = String.format("%.2f", d.getLimite() - d.getSaldo());
		fatura.setText(number);
		saldorestante.setText(number2);
	}
    
}
