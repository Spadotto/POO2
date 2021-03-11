package poo2.SistemaBanco.Controllers;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import poo2.SistemaBanco.App;
import poo2.SistemaBanco.Classes.Convenios;
import poo2.SistemaBanco.Classes.Usuario;
import poo2.SistemaBanco.DataBase.ConveniosDAO;
import poo2.SistemaBanco.DataBase.UsuarioDAO;

public class ConvController {
	
	private Usuario user;
	private Convenios convs;

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
	}

	@FXML
	private void UpdateConv() {
		if (user == null)
			return;
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
	
	public void UpdateConvs() {
		List<Convenios> convs = new ArrayList<>();
		((ConveniosDAO) convs).getAll();
		List<String> convs2 = new ArrayList<>();
		
		for (Convenios g : convs)
			convs2.add(g.getConvenio());
		convsList.setItems((FXCollections.observableArrayList(convs2)));

		if (user.getConvenio().isEmpty()) {
			solic.setDisable(true);
		} else {
			userList.getSelectionModel().select(0);
			solic.setDisable(false);
		}
	}
	
	@FXML
	private void solicita() {
		String cName = convsList.getSelectionModel().getSelectedItem();
		Convenios c = new ConveniosDAO().get(cName);
		user.getConvenio().add(c);
		new UsuarioDAO().persist(user);
		UpdateConv();
	}

	@FXML
	private void remove() {
		String cName = userList.getSelectionModel().getSelectedItem();
		Convenios c = new ConveniosDAO().get(cName);
		user.getConvenio().remove(c);
		new UsuarioDAO().persist(user);
		UpdateConv();
	}

}
