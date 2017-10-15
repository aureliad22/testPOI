/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni_ecole.models.Car;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public interface ICarDAO {

	public void insert(Car car) throws SQLException;
	public void update(Car car) throws SQLException;
	public void delete(Car car) throws SQLException;
	public Car selectById(int id) throws SQLException;
	public List<Car> selectAll() throws SQLException;
}
