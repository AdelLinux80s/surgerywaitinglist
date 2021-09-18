package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.service.PatientService;

@RestController
@RequestMapping("/surgeon")
public class SurgeonController {

	@Autowired
	private SurgeonService surgeonService;
	
	public Surgeon surgeonGetOne(Long surgeonId) {
		return surgeonService.surgeonGetOne(surgeonId);
	}
	
	public List<Surgeon> surgeonGetAll(){
		return surgeonService.surgeonGetAll();
		}
	
	
	public Surgeon addSurgeon(Surgeon surgeon) {
		return surgeonService.addSurgeon(surgeon);
	}
	
	public Surgeon removeSurgeon(Surgeon surgeon) {
		return surgeonService.removeSurgeon(surgeon);
	}
	
	
	
	
}
