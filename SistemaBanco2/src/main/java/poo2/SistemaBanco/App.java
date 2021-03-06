package poo2.SistemaBanco;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    
    private static Stage stage;
	private static Thread connection;

	@Override
	public void start(Stage stge) {
		stage = stge;
		stage.setScene(FXMLUtil.loadScene("login"));
		changeResizable();
		stage.setTitle("Banco");
		stage.show();
		connection.start();
	}
	
	public static void setConnection(Thread connection) {
		App.connection = connection;
	}

	public static void setRoot(String fxml) {
		stage.setScene(FXMLUtil.loadScene(fxml));
	}

	public static void changeResizable() {
		if (stage.isResizable())
			stage.setResizable(false);
		else
			stage.setResizable(true);
	}

}
