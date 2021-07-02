package com.example.CitizenService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitizenService.Pojo.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
