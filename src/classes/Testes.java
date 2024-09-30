package classes;

import java.sql.SQLException;

public class Testes {
	public static void main(String[] args) {
		try {
			Tela tl = new Tela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
