/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.models.Driver;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class DriverDAOImpl implements IDriverDAO{

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.IDriverDAO#insert(fr.eni_ecole.models.Driver)
	 */
	@Override
	public void insert(Driver driver) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.IDriverDAO#update(fr.eni_ecole.models.Driver)
	 */
	@Override
	public void update(Driver driver) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.IDriverDAO#delete(fr.eni_ecole.models.Driver)
	 */
	@Override
	public void delete(Driver driver) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.IDriverDAO#selectById(int)
	 */
	@Override
	public Driver selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.IDriverDAO#selectAll()
	 */
	@Override
	public List<Driver> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	private Driver buildDriver(ResultSet rs) {
		Driver result = new Driver();
		return result;
	}
}
