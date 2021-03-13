package poo2.SistemaBanco.DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import poo2.SistemaBanco.Classes.Usuario;

public class UsersInFile {

	public void check() {
		String fileLocation = "./local-users.json";
		List<String> fileLines = new ArrayList<>();
		try {
			File file = new File(fileLocation);
			if (file.exists()) {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine())
					fileLines.add(scanner.nextLine());
				scanner.close();
			} else {
				System.err.println("File \"" + fileLocation + "\" is missing.");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error while opening file \"" + fileLocation + "\".");
		}

		List<Usuario> userList = ConnectionDB.consumeAPI(fileLines);
		for (Usuario u : userList) {
			Usuario us = new UsuarioDAO().get(u.getCpf());
			if (!(us == null)) {
				if (!u.getSenha().contentEquals(us.getSenha())) {
					new UsuarioDAO().persist(u);
				}
			} else {
				new UsuarioDAO().persist(u);
			}
		}
	}
}
