package poo2.SistemaBanco.Controllers;

import javax.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.CartaoDAO;
import poo2.SistemaBanco.DataBase.ConnectionDB;
import poo2.SistemaBanco.DataBase.UsuarioDAO;

public class ConfigController {

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
    private TextField txtconta;

    @FXML
    private Button Alterar;

    @FXML
    private Button apagar;

    @FXML
    private Button voltar;

	private Usuario user;

    @FXML
    void AlterarDados(ActionEvent event) {
    	String cpf = txtcpf.getText();
    	String nome = txtnome.getText();
    	String sobrenome = txtsobrenome.getText();
    	String dataNasc = txtdanasc.getText();
    	String endereco = txtend.getText();
    	String cidade = txtcidade.getText();
		String email = txtemail.getText();

		if (cpf.isBlank()) {
			Alert alert = poo2.SistemaBanco.AlertUtil.error("Erro!", "Erro!", "Digite o CPF!");
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
		
		EntityManager em = ConnectionDB.getEntityManager();
		em.getTransaction().begin();
		Usuario person = new Usuario();
		person.setCpf(cpf);
		person.setNome(nome);
		person.setSobrenome(sobrenome);
		person.setCartao(user.getCartao());
		person.setCidade(cidade);
		person.setDataNasc(dataNasc);
		person.setEmail(email);
		person.setEndereco(endereco);
		person.setSenha(user.getSenha());
		person.setConvenios(user.getConvenio());
		em.getTransaction().commit();
		
		user = person;
		Alert alert = poo2.SistemaBanco.AlertUtil.info("Alerta", "Alerta", "Cadastro atualizado com sucesso");
		alert.showAndWait();
		
    }

    @FXML
    void ApagarUsuário(ActionEvent event) {
		Usuario user = new UsuarioDAO().get(txtcpf.getText());
		UsuarioDAO u = new UsuarioDAO();
		CartaoDAO c = new CartaoDAO();
		c.remove(user.getCartao());
		u.remove(user);
		App.setRoot("login");
		App.changeResizable();
    }

    @FXML
    void VoltarLogin(ActionEvent event) {
    	App.setRoot("main");
    	MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(user);
    }
    
    public void UserInfo(Usuario u) {
    	this.user = u;
    	txtnome.setText(user.getNome());
		txtcpf.setText(user.getCpf());
		txtsobrenome.setText(user.getSobrenome());
		txtemail.setText(user.getEmail());
		txtend.setText(user.getEndereco());
		txtcidade.setText(user.getCidade());
		txtdanasc.setText(user.getDataNasc());
		txtconta.setText(user.getCartao().getNumCartao());
	}

}
