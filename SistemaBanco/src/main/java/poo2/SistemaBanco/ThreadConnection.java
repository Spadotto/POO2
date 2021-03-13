package poo2.SistemaBanco;

import poo2.SistemaBanco.DataBase.UsersInFile;

public class ThreadConnection implements Runnable {

	
	@Override
	public void run() {	
		UsersInFile usersInFile = new UsersInFile();
		try {
			while (true) {
				System.out.println("Atualizando UsersFile!");
				usersInFile.check();
				Thread.sleep(4200);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
