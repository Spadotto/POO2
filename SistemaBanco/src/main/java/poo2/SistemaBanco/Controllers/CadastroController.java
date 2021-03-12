package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.CartaoDAO;
import poo2.SistemaBanco.DataBase.UsuarioDAO;

public class CadastroController {

	Random rand = new Random();
	
	@FXML
    private TextField txtnome;

    @FXML
    private TextField txtsobrenome;

    @FXML
    private TextField txtcpf;

    @FXML
    private TextField txtdanasc;

    @FXML
    private TextField txtend;

    @FXML
    private TextField txtcidade;

    @FXML
    private TextField txtemail;

    @FXML
    private PasswordField txtsenha;

    @FXML
    private PasswordField txtsenha2;
	
    @FXML
    private Button cadastrar;

    @FXML
    private Button voltar;

    @FXML
    private Button sair;

    @FXML
    void CadastrarUsuário(ActionEvent event) throws IOException {
    	String cpf = txtcpf.getText();
    	String senha = txtsenha.getText();
    	String nome = txtnome.getText();
    	String sobrenome = txtsobrenome.getText();
    	String dataNasc = txtdanasc.getText();
    	String endereco = txtend.getText();
    	String cidade = txtcidade.getText();
		String email = txtemail.getText();
		String cartaon = String.valueOf(rand.nextInt(999999999 - 100000000) + 100000000);
		String cvv = String.valueOf(rand.nextInt(999 - 100) + 100);
		String data = String.valueOf(rand.nextInt(9999 - 1000) + 1000);
		Cartao cartao = new Cartao(cartaon, cvv, data, 0, 100.00);

		if (cpf.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o CPF!");
			alert.showAndWait();
			return;
		}
		if(!senha.contentEquals(txtsenha2.getText())) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Senhas não conferem!");
			alert.showAndWait();
			return;
		}
		if (senha.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite a senha!");
			alert.showAndWait();
			return;
		}
		if (nome.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o nome!");
			alert.showAndWait();
			return;
		}
		if (sobrenome.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o sobrenome!");
			alert.showAndWait();
			return;
		}
		if (dataNasc.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite a data de nascimento!");
			alert.showAndWait();
			return;
		}
		if (endereco.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o endereço!");
			alert.showAndWait();
			return;
		}
		if (cidade.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite a cidade!");
			alert.showAndWait();
			return;
		}
		if (email.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o e-mail!");
			alert.showAndWait();
			return;
		}
		Usuario u = new UsuarioDAO().get(cpf);
		if (u != null) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Erro ao cadastrar usuário!");
			alert.showAndWait();
			return;
		}		
		else {
			new CartaoDAO().persist(cartao);
			new UsuarioDAO().persist(new Usuario(cpf, senha, nome, sobrenome, dataNasc, endereco, cidade, email, cartao));
		}

		Alert alert = poo2.SistemaBanco.AlertUtil.info("Alerta", "Alerta", "Cadastro realizado com sucesso");
		alert.showAndWait();
		
		App.setRoot("login");
    	Stage stage = (Stage) txtemail.getScene().getWindow();
		stage.close();
    }

    @FXML
    void Sair(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void VoltarLogin(ActionEvent event) throws IOException {
    	App.setRoot("login");
    	Stage stage = (Stage) txtemail.getScene().getWindow();
		stage.close();
    }

}
