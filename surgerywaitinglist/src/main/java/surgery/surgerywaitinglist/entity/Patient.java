package surgery.surgerywaitinglist.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue
	private Long patientId;
	private Long patientNationalID;
	private String patientFirstName;
	private String patientLastName;
	private String patientNationality;
	private Date patientDateOfBirth;
	private String patientGender;
	private String maritalStatus;
	private String patientAddress;
	private String patientConact;
	private String patientEmailAddress;
	private String patientBloodType;
	private String patientOccupation;
}
