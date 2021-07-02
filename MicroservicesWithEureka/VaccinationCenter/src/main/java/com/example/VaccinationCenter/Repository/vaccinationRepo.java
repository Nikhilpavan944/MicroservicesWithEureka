package com.example.VaccinationCenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VaccinationCenter.Pojo.VaccinationPojo;

public interface vaccinationRepo extends JpaRepository<VaccinationPojo, Integer>{

}
