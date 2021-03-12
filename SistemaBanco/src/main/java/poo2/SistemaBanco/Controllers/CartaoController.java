package poo2.SistemaBanco.Controllers;

import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.CartaoDAO;

public class CartaoController {
	
	private Usuario c;
	
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
		controller.UserInfo(c);
	}
	
	@FXML
    void ApagarCartao(ActionEvent event) throws IOException {
		String cartao = String.valueOf(rand.nextInt(999999999 - 100000000) + 100000000);
		String cvv = String.valueOf(rand.nextInt(999 - 100) + 100);
		Cartao cs = new CartaoDAO().get(lblcartao.getText());
		Cartao ct = new Cartao(cartao, cs.getDatavenc(), cvv, cs.getSaldo(), cs.getLimite());
		new CartaoDAO().persist(ct);
		new CartaoDAO().remove(cs); 
		c.setCartao(ct);
		App.setRoot("main");
		MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(c);
    }
	
	void setNumConta(Cartao d) {
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
