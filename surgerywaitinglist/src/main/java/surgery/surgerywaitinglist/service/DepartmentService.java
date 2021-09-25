package surgery.surgerywaitinglist.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.exception.DepartmentNotFoundException;
import surgery.surgerywaitinglist.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	//@Autowired
	//private SurgeonService surgeonService;
	
	public List<Department> departmentGetAll() {
		return departmentRepo.findAll();
	}

	public Department departmentGetOne(Long departmentId) {
		
		return departmentRepo.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException(departmentId));
	}

	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department removeDepartment(Long departmentId) {
		Department department = departmentGetOne(departmentId);
		departmentRepo.delete(department);
		return department;
	}

//	@Transactional
//	public Department addSurgeonToDepartment(Long departmentId, Long surgeonId) {
//		Department department = departmentGetOne(departmentId);
//		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
//		//Set<Surgeon> in Department ... deleted
//		//department.addSurgeonToDepartmentList(surgeon);
//		surgeon.setDepartmentIdInSurgery(department.getDepartmentId());
//		
//		return department;
//	}
//
//	@Transactional
//	public Department removeSurgeonToDepartment(Long departmentId, Long surgeonId) {
//		//Not needed anymore
//		Department department = departmentGetOne(departmentId);
//		
//		
//		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
//		
//		
//		//Set<Surgeon> in Department ... deleted
//		//department.removeSurgeonToDepartmentList(surgeon);
//		surgeon.setDepartmentIdInSurgery(null);
//		return department;
//	}
	
	

	
	
	

}
