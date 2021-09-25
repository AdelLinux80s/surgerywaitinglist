package surgery.surgerywaitinglist.exception;

import java.text.MessageFormat;

public class SurgeonNotAssignedToDepartment extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurgeonNotAssignedToDepartment(Long surgeonId) {
		super(MessageFormat.format("Surgeon with id: {0} is not assigned to department yet", surgeonId));
	}
	
}
