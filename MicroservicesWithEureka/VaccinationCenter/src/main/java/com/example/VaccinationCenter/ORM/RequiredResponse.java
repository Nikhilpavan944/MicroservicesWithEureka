package com.example.VaccinationCenter.ORM;

import java.util.List;

import com.example.VaccinationCenter.Pojo.VaccinationPojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

	//---- This pojo is for combined the Citizen and Vaccine details
	private VaccinationPojo center;
	private List<Citizens> citizens;
	public VaccinationPojo getCenter() {
		return center;
	}
	public void setCenter(VaccinationPojo center) {
		this.center = center;
	}
	public List<Citizens> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizens> citizens) {
		this.citizens = citizens;
	}
	
}
