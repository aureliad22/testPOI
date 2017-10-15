/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class ConnectionPool {

	/**
	 * Méthode en charge de fournir une connexion à la base de données.
	 * 
	 * @return
	 * @throws MyException
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		Connection cnx =null;

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/CarLocation";
			String user = "oreade";
			String passwd = "";

			cnx = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnx;
	}
}
