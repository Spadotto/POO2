package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import java.util.Random;
import javax.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.ConnectionDB;

public class CartaoController {
	
	private Usuario uc;
	private Cartao dc;
	
	Random rand = new Random();
	
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
		controller.UserInfo(uc);
	}
	
	@FXML
    void ApagarCartao(ActionEvent event) throws IOException {
		String cartao = String.valueOf(rand.nextInt(999999999 - 100000000) + 100000000);
		String cvv = String.valueOf(rand.nextInt(999 - 100) + 100);
		
		EntityManager em = ConnectionDB.getEntityManager();
		em.getTransaction().begin();
		Cartao c = new Cartao();
		c.setCvv(cvv);
		c.setDatavenc(dc.getDatavenc());
		c.setLimite(dc.getLimite());
		c.setSaldo(dc.getSaldo());
		c.setNumCartao(cartao);
		em.getTransaction().commit();
		this.dc = c;

		App.setRoot("main");
		MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(uc);
    }
	
	void setNumConta(Cartao d) {
		this.dc = d;
		lblcartao.setText(dc.getNumCartao());
		txtdatavenc.setText(dc.getDatavenc());
		txtcvv.setText(dc.getCvv());
	}

	public void setDados(Usuario c) {
		this.uc = c;
		txtnome.setText(uc.getNome());
		txtsobrenome.setText(uc.getSobrenome());
	}

}
