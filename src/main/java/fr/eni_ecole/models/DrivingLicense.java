/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.models;

import java.io.Serializable;
import java.time.Year;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class DrivingLicense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int yearOfLicense;
	private String country;
	
	/**
	 * Constructeur.
	 */
	public DrivingLicense() {
		super();
	}
	/**
	 * Constructeur.
	 * @param id
	 * @param yearOfLicense
	 * @param country
	 */
	public DrivingLicense(int id, int yearOfLicense, String country) {
		super();
		this.setId(id);
		this.setYearOfLicense(yearOfLicense);
		this.setCountry(country);
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
	 * Getter pour yearOfLicense.
	 * @return the yearOfLicense
	 */
	public int getYearOfLicense() {
		return yearOfLicense;
	}
	/**
	 * Setter pour yearOfLicense.
	 * @param yearOfLicense the yearOfLicense to set
	 */
	public void setYearOfLicense(int yearOfLicense) {
		this.yearOfLicense = yearOfLicense;
	}
	/**
	 * Getter pour country.
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Setter pour country.
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Permis [id=").append(id).append(", yearOfLicense=").append(yearOfLicense).append(", country=")
				.append(country).append("]");
		return builder.toString();
	}
}
