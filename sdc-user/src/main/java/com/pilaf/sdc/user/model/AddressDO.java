package com.pilaf.sdc.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5958720317004783935L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String zipCode;

	private String city;

	private String province;

	private Country country;

	private String houseNr;

	private String flatNumber;

	public AddressDO() {
		super();
	}

	public AddressDO(String zipCode, String city, String province, Country country, String houseNr, String flatNumber) {
		super();
		this.zipCode = zipCode;
		this.city = city;
		this.province = province;
		this.country = country;
		this.houseNr = houseNr;
		this.flatNumber = flatNumber;
	}

	public AddressDO(Long id, String zipCode, String city, String province, Country country, String houseNr,
			String flatNumber) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.city = city;
		this.province = province;
		this.country = country;
		this.houseNr = houseNr;
		this.flatNumber = flatNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((flatNumber == null) ? 0 : flatNumber.hashCode());
		result = prime * result + ((houseNr == null) ? 0 : houseNr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDO other = (AddressDO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country != other.country)
			return false;
		if (flatNumber == null) {
			if (other.flatNumber != null)
				return false;
		} else if (!flatNumber.equals(other.flatNumber))
			return false;
		if (houseNr == null) {
			if (other.houseNr != null)
				return false;
		} else if (!houseNr.equals(other.houseNr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

}
