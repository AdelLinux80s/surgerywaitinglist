package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.entity.Surgeon;

import surgery.surgerywaitinglist.service.SurgeonService;

@RestController
@RequestMapping("/surgeon")
public class SurgeonController {

	@Autowired
	private SurgeonService surgeonService;
	
	@GetMapping(value="{surgeonId}")
	public Surgeon surgeonGetOne(@PathVariable Long surgeonId) {
		return surgeonService.surgeonGetOne(surgeonId);
	}
	
	@GetMapping
	public List<Surgeon> surgeonGetAll(){
		return surgeonService.surgeonGetAll();
		}
	
	@PostMapping
	public Surgeon addSurgeon(@RequestBody Surgeon surgeon) {
		return surgeonService.addSurgeon(surgeon);
	}
	
	@DeleteMapping(value="{surgeonId}")
	public Surgeon removeSurgeon(@PathVariable Long surgeonId) {
		return surgeonService.removeSurgeon(surgeonId);
	}
	
	@PostMapping(value="{surgeonId}/department/{departmentId}/add")
	public Surgeon setDepartmentToSurgeon(@PathVariable Long surgeonId, @PathVariable Long departmentId) {
		return  surgeonService.setDepartmentToSurgeon(surgeonId, departmentId);
	}
	@DeleteMapping(value="{surgeonId}/remove")
	public Surgeon unsetDepartmentToSurgeon(@PathVariable Long surgeonId) {
		return  surgeonService.unsetDepartmentToSurgeon(surgeonId);
	}
	
	
	
	
}
