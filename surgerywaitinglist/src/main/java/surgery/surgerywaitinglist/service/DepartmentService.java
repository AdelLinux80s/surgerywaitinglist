package surgery.surgerywaitinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
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
	
	

	
	
	

}
