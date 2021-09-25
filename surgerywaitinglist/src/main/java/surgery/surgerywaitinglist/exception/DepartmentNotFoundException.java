package surgery.surgerywaitinglist.exception;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class DepartmentNotFoundException extends NoSuchElementException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException(Long departmentId) {
		super(MessageFormat.format("Could not find department with id: {0}", departmentId));
	}
}
