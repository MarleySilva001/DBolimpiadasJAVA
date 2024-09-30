package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BDUtil {
	public String sql;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public static final String URL_BD = "jdbc:postgresql://localhost:5432/olimpiadas";
	public static final String USER_BD = "postgres";
	public static final String PASS_BD = "postgres";
	List<String> lista = new ArrayList<String>();
	public List<String> getLista(){
		return lista;
	}
	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	public void executaBDSelect(String selectSql, String selectField) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL_BD, USER_BD, PASS_BD);
			String selectSQL = selectSql;
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			lista.add("");
			while(rs.next()) {
				String select = rs.getString(selectField);
				lista.add(select);
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Problema ao ace");
			e.printStackTrace();
		}finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	public void executaBDSelect(String string, String string2, String string3, String string4, String string5,
			String string6, String string7) {
		// TODO Auto-generated method stub
		
	}
}
