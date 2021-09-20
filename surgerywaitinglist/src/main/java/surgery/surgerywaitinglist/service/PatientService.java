package surgery.surgerywaitinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Patient;
import surgery.surgerywaitinglist.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	
	public List<Patient> patientGetAll() {
		return patientRepo.findAll();
	}
	
	public Patient patientGetOne(Long patientId) {
		
		//exception needed here
		return patientRepo.findById(patientId).get();
	}

	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	public Patient removePatient(Long patientId) {
		Patient patient = patientGetOne(patientId);
		patientRepo.delete(patient);
		return patient;
	}
	
	


	
	

	
	
}
