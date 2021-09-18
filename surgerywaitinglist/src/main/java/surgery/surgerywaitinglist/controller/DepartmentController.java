package surgery.surgerywaitinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	public Department departmentGetOne(Long departmentId) {
		departmentService.departmentGetOne(departmentId);
	}
	
	public List<Department> departmentGetAll(){
		return departmentService.departmentGetAll();
	}
	
	public Department addDepartment(Department department) {
		departmentService.addDepartment(department);
	}
	
	public Department removeDepartment(Department department) {
		departmentService.removeDepartment(department);
	}
}
