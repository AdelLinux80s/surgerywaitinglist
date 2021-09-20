package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value="{departmentId}")
	public Department departmentGetOne(@PathVariable Long departmentId) {
		return departmentService.departmentGetOne(departmentId);
	}
	@GetMapping
	public List<Department> departmentGetAll(){
		return departmentService.departmentGetAll();
	}
	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	@DeleteMapping(value="{departmentId}")
	public Department removeDepartment(@PathVariable Long departmentId) {
		return departmentService.removeDepartment(departmentId);
	}
}
