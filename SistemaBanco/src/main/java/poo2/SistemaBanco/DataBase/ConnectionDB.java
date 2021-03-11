package poo2.SistemaBanco.DataBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poo2.SistemaBanco.Classes.Cartao;
import poo2.SistemaBanco.Classes.Convenios;
import poo2.SistemaBanco.Classes.Usuario;

public class ConnectionDB {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	private static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("teste");
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null)
			entityManager = getEntityManagerFactory().createEntityManager();
		return entityManager;
	}
	
	public static void closeConn() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}
	
	public static void initDB() {

		for (Usuario u : consumeAPI(consultAPI()))
			new UsuarioDAO().persist(u);

		Cartao c = new Cartao("12346451561", "17/25", "123", 254.00, 400.00);
		new CartaoDAO().persist(c);
		
		Usuario u = new Usuario("a", "a", "qwe", "qwe", "qwe", "qwe", "qwe", "qwe", c);
		new UsuarioDAO().persist(u);
		
		Convenios a = new Convenios("amil");
		new ConveniosDAO().persist(a);
		Convenios b = new Convenios("ecosalva");
		new ConveniosDAO().persist(b);
		Convenios g = new Convenios("itaipu");
		new ConveniosDAO().persist(g);
		Convenios d = new Convenios("sanepar");
		new ConveniosDAO().persist(d);
		Convenios e = new Convenios("sulamerica");
		new ConveniosDAO().persist(e);
		Convenios f = new Convenios("unimed");
		new ConveniosDAO().persist(f);
	
	}

	public static List<Usuario> consumeAPI(List<String> users) {
		List<Usuario> result = new ArrayList<Usuario>();
		for (int lineIndex = 0; lineIndex < users.size(); lineIndex++) {
			String line = users.get(lineIndex);
			if (line.contains("username")) {
				String username = processJSONLine(line);
				lineIndex++;
				line = users.get(lineIndex);
				String password = processJSONLine(line);
				
				Cartao ct = new Cartao("6666666666666", "06/26", "666", 30.00, 200.00);
				new CartaoDAO().persist(ct);
				
				Usuario user = new Usuario(username, password, "nome", "sobrenome", "data", "endereco", "cidade", "email", ct);
				result.add(user);
			}
		}
		return result;
	}

	private static String processJSONLine(String line) {
		String[] dividedLine = line.split(":");
		String username = dividedLine[1];
		username = username.replace(",", " ");
		username = username.replace("\"", " ");
		username = username.trim();
		return username;
	}

	private static List<String> consultAPI() {
		List<String> result = new ArrayList<>();
		try {
			URL url = new URL("http://www.lucasbueno.com.br/steam.json");
			URLConnection uc = url.openConnection();
			InputStreamReader input = new InputStreamReader(uc.getInputStream());
			BufferedReader in = new BufferedReader(input);
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				result.add(inputLine);

			in.close();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.showAndWait();
		}
		return result;
	}

}
