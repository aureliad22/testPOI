/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.models.Car;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class CarDAOImpl implements ICarDAO {

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.ICarDAO#insert(fr.eni_ecole.models.Car)
	 */
	@Override
	public void insert(Car car) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.ICarDAO#update(fr.eni_ecole.models.Car)
	 */
	@Override
	public void update(Car car) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.ICarDAO#delete(fr.eni_ecole.models.Car)
	 */
	@Override
	public void delete(Car car) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.ICarDAO#selectById(int)
	 */
	@Override
	public Car selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.dao.ICarDAO#selectAll()
	 */
	@Override
	public List<Car> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	private Car buildCar(ResultSet rs) {
		Car result = new Car();
		return result;
	}
}
