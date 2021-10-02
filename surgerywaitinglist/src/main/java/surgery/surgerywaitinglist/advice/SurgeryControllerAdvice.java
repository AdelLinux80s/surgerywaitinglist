package surgery.surgerywaitinglist.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import surgery.surgerywaitinglist.exception.DepartmentNotFoundException;
import surgery.surgerywaitinglist.exception.PatientNotFoundEception;
import surgery.surgerywaitinglist.exception.SurgeonNotAssignedToDepartment;
import surgery.surgerywaitinglist.exception.SurgeonNotFoundException;
import surgery.surgerywaitinglist.exception.WaitingListNotFoundException;

@ControllerAdvice
public class SurgeryControllerAdvice {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleDepartmentNotFoundException(DepartmentNotFoundException exc){
		return new ResponseEntity<String>("Department Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PatientNotFoundEception.class)
	public ResponseEntity<String> handlePatientNotFoundEception(PatientNotFoundEception exc){
		return new ResponseEntity<String>("Patient Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SurgeonNotFoundException.class)
	public ResponseEntity<String> handleSurgeonNotFoundException(SurgeonNotFoundException exc){
		return new ResponseEntity<String>("Surgeon Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SurgeonNotAssignedToDepartment.class)
	public ResponseEntity<String> handleSurgeonNotAssignedToDepartment(SurgeonNotAssignedToDepartment exc){
		return new ResponseEntity<String>("Surgeon Not Assigned To Department", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WaitingListNotFoundException.class)
	public ResponseEntity<String> handleWaitingListNotFoundException(WaitingListNotFoundException exc){
		return new ResponseEntity<String>("Case Not Found", HttpStatus.NOT_FOUND);
	}
}
