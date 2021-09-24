package surgery.surgerywaitinglist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.entity.Surgeon;
import surgery.surgerywaitinglist.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	@Autowired
	private SurgeonService surgeonService;
	
	public List<Department> departmentGetAll() {
		return departmentRepo.findAll();
	}

	public Department departmentGetOne(Long departmentId) {
		//exception to be added
		return departmentRepo.findById(departmentId).get();
	}

	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department removeDepartment(Long departmentId) {
		Department department = departmentGetOne(departmentId);
		departmentRepo.delete(department);
		return department;
	}

	@Transactional
	public Department addSurgeonToDepartment(Long departmentId, Long surgeonId) {
		Department department = departmentGetOne(departmentId);
		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
		department.addSurgeonToDepartmentList(surgeon);
		return department;
	}

	@Transactional
	public Department removeSurgeonToDepartment(Long departmentId, Long surgeonId) {
		Department department = departmentGetOne(departmentId);
		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
		department.removeSurgeonToDepartmentList(surgeon);
		return department;
	}
	
	

	
	
	

}
