package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.entity.Patient;
import surgery.surgerywaitinglist.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public List<Patient> patientGetAll(){
		return patientService.patientGetAll();
	}
	
	@GetMapping(value="{patientId}")
	public Patient patientGetOne(@PathVariable Long patientId) {
		return patientService.patientGetOne(patientId);
	}
	
	
	@PostMapping
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	@DeleteMapping(value="{patientId}")
	public Patient removePatient(@PathVariable Long patientId) {
		return patientService.removePatient(patientId);
	}
	
	
}
