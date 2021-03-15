package poo2.SistemaBanco;

import javafx.application.Application;
import poo2.SistemaBanco.DataBase.ConnectionDB;

public class Main {

	public static void main(String[] args) {
		
		Thread connection = new Thread(new ThreadConnection());
		App.setConnection(connection);
		
		ConnectionDB.initDB();
		
		System.out.println("Os usuários do arquivo local estão sendo lidos e salvos no banco...");
		new poo2.SistemaBanco.DataBase.UsersInFile().check();
		
		Application.launch(App.class);
		
		ConnectionDB.closeConn();
		connection.interrupt();

	}

}
