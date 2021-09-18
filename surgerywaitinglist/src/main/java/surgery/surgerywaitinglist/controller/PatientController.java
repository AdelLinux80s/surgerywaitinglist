package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	public Patient patientGetOne(Long studentId) {
		return patientService.patientGetOne(studentId);
	}
	
	public List<Patient> patientGetAll(){
		return patientService.patientGetAll();
	}
	
	public Patient addPatient(Patient patient) {
		return patientService.addPatient(patient);
	}
	
	public Patient removePatient(Long patientId) {
		return patientService.removePatient(patientId);
	}
	
	
}
