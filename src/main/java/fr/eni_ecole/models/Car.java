/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
package fr.eni_ecole.models;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oreade
 * @date 14 oct. 2017
 * @version TestPOI V1.0
 */
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String brand;
	private String model;
	private Year yearOfService;
	private List<Driver> listDrivers = new ArrayList<>();
	
	/**
	 * Constructeur.
	 */
	public Car() {
		super();
	}
	
	/**
	 * Constructeur.
	 * @param id
	 * @param brand
	 * @param model
	 * @param yearOfService
	 */
	public Car(int id, String brand, String model, Year yearOfService) {
		super();
		this.setId(id);
		this.setBrand(brand);
		this.setModel(model);
		this.setYearOfService(yearOfService);
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
	 * Getter pour brand.
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter pour brand.
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter pour model.
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Setter pour model.
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Getter pour yearOfService.
	 * @return the yearOfService
	 */
	public Year getYearOfService() {
		return yearOfService;
	}

	/**
	 * Setter pour yearOfService.
	 * @param yearOfService the yearOfService to set
	 */
	public void setYearOfService(Year yearOfService) {
		this.yearOfService = yearOfService;
	}

	/**
	 * Getter pour listDrivers.
	 * @return the listDrivers
	 */
	public List<Driver> getListDrivers() {
		return listDrivers;
	}

	/**
	 * Setter pour listDrivers.
	 * @param listDrivers the listDrivers to set
	 */
	public void setListDrivers(List<Driver> listDrivers) {
		this.listDrivers = listDrivers;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id=").append(id).append(", brand=").append(brand).append(", model=").append(model)
				.append(", yearOfService=").append(yearOfService).append("]");
		return builder.toString();
	}
	
}
