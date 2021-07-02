package com.example.VaccinationCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.VaccinationCenter.ORM.Citizens;
import com.example.VaccinationCenter.ORM.RequiredResponse;
import com.example.VaccinationCenter.Pojo.VaccinationPojo;
import com.example.VaccinationCenter.Repository.vaccinationRepo;
@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	
		
		@Autowired
		private vaccinationRepo centerRepo;
		
		@Autowired
		private RestTemplate restTemplate;
		
		@PostMapping(path ="/add")
		public ResponseEntity<VaccinationPojo> addCitizen(@RequestBody VaccinationPojo vaccinationCenter) {
			
			VaccinationPojo vaccinationCenterAdded = centerRepo.save(vaccinationCenter);
			return new ResponseEntity<>(vaccinationCenterAdded, HttpStatus.OK);
		}
		
		@GetMapping(path = "/id/{id}")
		public ResponseEntity<RequiredResponse> getAllDataBasedonCenterId(@PathVariable Integer id){
			RequiredResponse requiredResponse =  new RequiredResponse();
			//1st get vaccination center detail
			VaccinationPojo center  = centerRepo.findById(id).get();
			requiredResponse.setCenter(center);
			
			// then get all citizen registerd to vaccination center
			
			java.util.List<Citizens> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
			requiredResponse.setCitizens(listOfCitizens);
			return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
		}
		

}
