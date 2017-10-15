/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String lastName;
	private String firstName;
	private DrivingLicense driverLicense;
	private List<Car> listCars = new ArrayList<Car>();

	
	/**
	 * Constructeur.
	 */
	public Driver() {
		super();
	}
	
	/**
	 * Constructeur.
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param address
	 * @param zipCode
	 * @param city
	 * @param permisDeConduire
	 */
	public Driver(int id, String lastName, String firstName, DrivingLicense driverLicense) {
		super();
		this.setId(id);
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setDriverLicense(driverLicense);
	}

	/**
	 * Getter pour id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour lastName.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter pour lastName.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter pour firstName.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter pour firstName.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter pour permisDeConduire.
	 * @return the permisDeConduire
	 */
	public DrivingLicense getDriverLicense() {
		return driverLicense;
	}

	/**
	 * Setter pour permisDeConduire.
	 * @param permisDeConduire the permisDeConduire to set
	 */
	public void setDriverLicense(DrivingLicense driverLicense) {
		this.driverLicense = driverLicense;
	}

	/**
	 * Getter pour listCars.
	 * @return the listCars
	 */
	public List<Car> getListCars() {
		return listCars;
	}

	/**
	 * Setter pour listCars.
	 * @param listCars the listCars to set
	 */
	public void setListCars(List<Car> listCars) {
		this.listCars = listCars;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Driver [id=").append(id).append(", lastName=").append(lastName).append(", firstName=")
				.append(firstName).append("]");
		return builder.toString();
	}
}
