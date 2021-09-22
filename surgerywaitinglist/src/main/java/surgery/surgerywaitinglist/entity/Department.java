package surgery.surgerywaitinglist.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue
	private Long departmentId;
	private String departmentName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id")
	private Set<Surgeon> surgeons = new HashSet<>();
	
}
