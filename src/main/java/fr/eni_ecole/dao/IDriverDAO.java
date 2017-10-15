/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.models.Driver;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public interface IDriverDAO {
	
	public void insert(Driver driver) throws SQLException;
	public void update(Driver driver) throws SQLException;
	public void delete(Driver driver) throws SQLException;
	public Driver selectById(int id) throws SQLException;
	public List<Driver> selectAll() throws SQLException;
}
