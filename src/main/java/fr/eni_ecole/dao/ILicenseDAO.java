/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.models.DrivingLicense;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public interface ILicenseDAO {
	
	public void insert(DrivingLicense license) throws SQLException;
	public void update(DrivingLicense license) throws SQLException;
	public void delete(DrivingLicense license) throws SQLException;
	public DrivingLicense selectById(int id) throws SQLException;
	public List<DrivingLicense> selectAll() throws SQLException;
	public List<DrivingLicense> importAll(String fileName) throws Exception;
	public void exportAll(String fileName) throws Exception;
}
