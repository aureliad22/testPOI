/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole;

import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.dao.LicenseDAOImpl;
import fr.eni_ecole.models.DrivingLicense;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class Main {

	/**
	 * Méthode main, point d'entrée dans l'application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LicenseDAOImpl lDAO = new LicenseDAOImpl();

		// Read from Database:
		System.out.println("Read from database");
		try {
			List<DrivingLicense> list = lDAO.selectAll();
			for (DrivingLicense drivingLicense : list) {
				System.out.println(drivingLicense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("#######################################");

		// Read from Excel
		System.out.println("Read from excel");
		try {
			List<DrivingLicense> listImport = lDAO.importAll("src/main/resources/Conducteur01.xlsx");
			for (DrivingLicense drivingLicense : listImport) {
				System.out.println(drivingLicense);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("#######################################");

		// Export from database to Excel
		System.out.println("Write into Excel, from DB");
		try {
			lDAO.exportAll("src/main/resources/Conducteur02.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Import from Excel to Database
		System.out.println("Write into DB, from Excel");
		try {
			List<DrivingLicense> listImport = lDAO.importAllIntoDB("src/main/resources/Conducteur01.xlsx");
			for (DrivingLicense drivingLicense : listImport) {
				System.out.println(drivingLicense);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
