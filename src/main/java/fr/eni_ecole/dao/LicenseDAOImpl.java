/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.eni_ecole.models.DrivingLicense;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class LicenseDAOImpl implements ILicenseDAO {
	private static final Logger log = Logger.getLogger(LicenseDAOImpl.class);

	private static final String SELECT_ALL_DRIVING_LICENSES = "SELECT * FROM \"DRIVING_LICENSES\"";
	private static final String INSERT_LICENSE = "INSERT INTO \"DRIVING_LICENSES\"" + "(id, country, year) "
			+ "VALUES(?,?,?);";


	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#insert(fr.eni_ecole.models.DrivingLicense)
	 */
	@Override
	public void insert(DrivingLicense license) throws SQLException {
		try (Connection cnx = ConnectionPool.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(INSERT_LICENSE);
			cmd.setInt(1, license.getId());
			cmd.setString(2, license.getCountry());
			cmd.setInt(3, license.getYearOfLicense());
			cmd.execute();

		} catch (SQLException e) {
			log.error("Erreur : " + e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#update(fr.eni_ecole.models.DrivingLicense)
	 */
	@Override
	public void update(DrivingLicense license) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#delete(fr.eni_ecole.models.DrivingLicense)
	 */
	@Override
	public void delete(DrivingLicense license) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#selectById(int)
	 */
	@Override
	public DrivingLicense selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#selectAll()
	 */
	@Override
	public List<DrivingLicense> selectAll() throws SQLException {
		List<DrivingLicense> result = new ArrayList<>();

		try (Connection cnx = ConnectionPool.getConnection()) {
			PreparedStatement stm = cnx.prepareStatement(SELECT_ALL_DRIVING_LICENSES);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				result.add(buildLicense(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private DrivingLicense buildLicense(ResultSet rs) throws SQLException {
		DrivingLicense result = new DrivingLicense();
		result.setId(rs.getInt("id"));
		result.setYearOfLicense(rs.getInt("year"));
		result.setCountry(rs.getString("country"));
		return result;
	}

	/**
	 * Methode en charge d'importer les données a partir d'un fichier excel.
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#importAll()
	 */
	@Override
	public List<DrivingLicense> importAll(String fileName) throws Exception {
		final File file = new File(fileName);
		final List<DrivingLicense> result = new ArrayList<DrivingLicense>();

		try {
			// ouverture du fichier excel
			final Workbook workbook = WorkbookFactory.create(file);
			// lecture du fichier
			final Sheet sheet = workbook.getSheet("Feuille 2");
			int index = 1; // on saute la ligne de titres
			Row row = sheet.getRow(index++);

			while (row != null) {
				final DrivingLicense license = rowToLicense(row);
				result.add(license);
				row = sheet.getRow(index++);
			}

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * Méthode en charge de 
	 * @param string
	 * @return
	 */
	public List<DrivingLicense> importAllIntoDB(String fileName) throws Exception {
		final File file = new File(fileName);
		final List<DrivingLicense> result = new ArrayList<DrivingLicense>();

		try {
			// ouverture du fichier excel
			final Workbook workbook = WorkbookFactory.create(file);
			// lecture du fichier
			final Sheet sheet = workbook.getSheet("Feuille 2");
			int index = 1; // on saute la ligne de titres
			Row row = sheet.getRow(index++);

			while (row != null) {
				final DrivingLicense license = rowToLicense(row);
				insert(license);
				row = sheet.getRow(index++);
			}

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}

		return result;
	}
	
	/**
	 * Méthode en charge de lire la feuille excel, ligne par licence.
	 * 
	 * @param row
	 * @return
	 */
	private DrivingLicense rowToLicense(Row row) {
		DrivingLicense result = new DrivingLicense();

		final int id = (int) row.getCell(0).getNumericCellValue();
		result.setId(id);

		final String country = row.getCell(1).getStringCellValue();
		result.setCountry(country);

		final int year = (int) row.getCell(2).getNumericCellValue();
		result.setYearOfLicense(year);

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.dao.ILicenseDAO#exportAll()
	 */
	@Override
	public void exportAll(String fileName) throws Exception {
		try (Connection cnx = ConnectionPool.getConnection()) {
			PreparedStatement stm = cnx.prepareStatement(SELECT_ALL_DRIVING_LICENSES);
			ResultSet rs = stm.executeQuery();
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet("employe db");

			XSSFRow row = spreadsheet.createRow(1);
			XSSFCell cell;
			cell = row.createCell(1);
			cell.setCellValue("id");
			cell = row.createCell(2);
			cell.setCellValue("country");
			cell = row.createCell(3);
			cell.setCellValue("year");

			int i = 2;
			while (rs.next()) {
				row = spreadsheet.createRow(i);
				cell = row.createCell(1);
				cell.setCellValue(rs.getInt("id"));
				cell = row.createCell(2);
				cell.setCellValue(rs.getString("country"));
				cell = row.createCell(3);
				cell.setCellValue(rs.getString("year"));
				i++;
			}
			
			// Ecriture dans un fichier
			final File file = new File(fileName);
			// Depart d'une copie blanche a chaque fois.
			if (file.exists()) {
				file.delete();
			}
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			System.out.println("exceldatabase.xlsx written successfully");
		}
	}
}
