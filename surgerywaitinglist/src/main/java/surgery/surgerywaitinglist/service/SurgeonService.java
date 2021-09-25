package surgery.surgerywaitinglist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.entity.Surgeon;
import surgery.surgerywaitinglist.exception.SurgeonNotFoundException;
import surgery.surgerywaitinglist.repository.SurgeonRepository;

@Service
public class SurgeonService {

	@Autowired
	private SurgeonRepository surgeonRepo;
	@Autowired
	DepartmentService departmentService;
	
	
	public List<Surgeon> surgeonGetAll() {
		return surgeonRepo.findAll();
	
	}

	public Surgeon surgeonGetOne(Long surgeonId) {
		
		return surgeonRepo.findById(surgeonId).orElseThrow(() -> new SurgeonNotFoundException(surgeonId));
	}

	public Surgeon addSurgeon(Surgeon surgeon) {
		return surgeonRepo.save(surgeon);
	}

	public Surgeon removeSurgeon(Long surgeonId) {
		Surgeon surgeon = surgeonGetOne(surgeonId);
		surgeonRepo.delete(surgeon);
		return surgeon;
	}

	@Transactional
	public Surgeon setDepartmentToSurgeon(Long surgeonId, Long departmentId) {
		Surgeon surgeon = surgeonGetOne(surgeonId);
		Department department = departmentService.departmentGetOne(departmentId);
		surgeon.setDepartmentIdInSurgery(department.getDepartmentId());
		return surgeon;
	}

	@Transactional
	public Surgeon unsetDepartmentToSurgeon(Long surgeonId) {
		Surgeon surgeon = surgeonGetOne(surgeonId);
		surgeon.setDepartmentIdInSurgery(null);
		return surgeon;
	}
	
	
	
}
