package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	public Patient getOne(Long studentId) {
		return patientService.getOne(studentId);
	}
	
	
	public Patient addPatient(Patient patient) {
		return patientService.addPatient(patient);
	}
	
	
}
