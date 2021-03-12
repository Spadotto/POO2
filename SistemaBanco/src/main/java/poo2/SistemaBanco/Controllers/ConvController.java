package poo2.SistemaBanco.Controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import poo2.SistemaBanco.AlertUtil;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.FXMLUtil;
import poo2.SistemaBanco.Classes.Convenios;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.ConveniosDAO;

public class ConvController {

	private Usuario user;

	@FXML
	private ListView<String> convsList;

	@FXML
	private ListView<String> userList;

	@FXML
	private Button solic;

	@FXML
	private Button remov;

	@FXML
	private Button volta;

	@FXML
	private void voltar() {
		App.setRoot("main");
		MainController controller = FXMLUtil.getMainController();
		controller.UserInfo(user);
	}

	@FXML
	private void UpdateConv() {
		if (user == null) {
			AlertUtil.error("Erro", "Erro", "Não foi possível encontrar o usuario!");
			return;
		}
		List<String> userconvs = new ArrayList<>();
		for (Convenios g : user.getConvenio())
			userconvs.add(g.getConvenio());
		userList.setItems((FXCollections.observableList(userconvs)));

		if (user.getConvenio().isEmpty()) {
			remov.setDisable(true);
		} else {
			userList.getSelectionModel().select(0);
			remov.setDisable(false);
		}
	}

	public void UpdateConvs(Usuario user) {
		this.user = user;
		UpdateConv();
		List<String> convs = new ArrayList<>();
		
		if (convs.isEmpty()) {
			AlertUtil.error("Erro", "Erro", "Não foi possível carregar os convenios!");
		}
		for (Convenios g : new ConveniosDAO().getAll()) {
			if (!user.getConvenio().contains(g)) {
				convs.add(g.getConvenio());
			}
		}
		convsList.setItems((FXCollections.observableArrayList(convs)));

		if (convs.isEmpty()) {
			solic.setDisable(true);
		} else {
			userList.getSelectionModel().select(0);
			solic.setDisable(false);
		}
	}

	@FXML
	private void solicita() {
		if((convsList.getSelectionModel().getSelectedItem() == null)) {
			AlertUtil.error(null, null, null);
		}else {
			String cName = convsList.getSelectionModel().getSelectedItem();
			Convenios c = new ConveniosDAO().get(cName);
			user.getConvenio().add(c);
			UpdateConv();
			UpdateConvs(user);
		}
		
	}

	@FXML
	private void remove() {
		String cName = userList.getSelectionModel().getSelectedItem();
		Convenios c = new ConveniosDAO().get(cName);
		user.getConvenio().remove(c);
		UpdateConv();
		UpdateConvs(user);

	}

}
