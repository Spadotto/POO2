package poo2.SistemaBanco;

import javafx.application.Application;
import poo2.SistemaBanco.DataBase.ConnectionDB;

public class Main {

	public static void main(String[] args) {
		
		ConnectionDB.initDB();
		Application.launch(App.class);
		ConnectionDB.closeConn();

	}

}
