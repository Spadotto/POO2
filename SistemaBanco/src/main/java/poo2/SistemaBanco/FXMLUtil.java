package poo2.SistemaBanco;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poo2.SistemaBanco.Controllers.CartaoController;
import poo2.SistemaBanco.Controllers.ConfigController;
import poo2.SistemaBanco.Controllers.ConvController;
import poo2.SistemaBanco.Controllers.MainController;

public class FXMLUtil {
	private static MainController mainController = null;
	private static CartaoController cartaoController = null;
	private static ConfigController configController = null;
	private static ConvController convenioController = null;

	public static Scene loadScene(String fxml) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			if (fxmlLoader.getController() instanceof MainController)
				mainController = fxmlLoader.getController();
			else
				mainController = null;
			if (fxmlLoader.getController() instanceof CartaoController)
				cartaoController = fxmlLoader.getController();
			else
				cartaoController = null;
			if (fxmlLoader.getController() instanceof ConfigController)
				configController = fxmlLoader.getController();
			else
				configController = null;
			if (fxmlLoader.getController() instanceof ConvController)
				convenioController = fxmlLoader.getController();
			else
				convenioController = null;
			return scene;
		} catch (IOException eIO) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return null;
		} catch (IllegalStateException eIllegalState) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
			return null;
		}
	}

	public static MainController getMainController() {
		return mainController;
	}
	
	public static CartaoController getCartaoController() {
		return cartaoController;
	}
	
	public static ConfigController getConfigController() {
		return configController;
	}
	
	public static ConvController getConvController() {
		return convenioController;
	}

}
