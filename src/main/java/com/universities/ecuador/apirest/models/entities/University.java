package com.universities.ecuador.apirest.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "universities")
public class University implements Serializable {

	@Id
	@Column(nullable = false)
	private String id;

	@Column(length = 100, unique = true, nullable = false)
	private String name;

	@Column(length = 5, unique = false, nullable = false)
	private String category;

	@Column(length = 20, unique = false, nullable = false)
	private String financing;

	@Column(length = 100, unique = false, nullable = false)
	private String rector;

	@Column(length = 100, unique = false, nullable = false)
	private String province;

	@Column(length = 100, unique = false, nullable = false)
	private String city;

	@Column(length = 200, unique = false, nullable = false)
	private String address;

	@Column(length = 100, unique = false, nullable = false)
	private String email;

	@Column(length = 10, unique = false, nullable = false)
	private String acronym;

	@Column(unique = false, nullable = true)
	private Long students;

	@Column(name = "image_url", length = 1000, unique = false, nullable = true)
	private String imageUrl;
	
	@Column(length = 1000, unique = false, nullable = true)
	private String site;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFinancing() {
		return financing;
	}

	public void setFinancing(String financing) {
		this.financing = financing;
	}

	public String getRector() {
		return rector;
	}

	public void setRector(String rector) {
		this.rector = rector;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Long getStudents() {
		return students;
	}

	public void setStudents(Long students) {
		this.students = students;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}



	private static final long serialVersionUID = 1L;

}
