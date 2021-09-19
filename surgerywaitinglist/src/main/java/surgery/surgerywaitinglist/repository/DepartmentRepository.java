package surgery.surgerywaitinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import surgery.surgerywaitinglist.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
