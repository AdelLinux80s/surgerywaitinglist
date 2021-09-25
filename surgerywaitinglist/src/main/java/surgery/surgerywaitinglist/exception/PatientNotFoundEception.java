package surgery.surgerywaitinglist.exception;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class PatientNotFoundEception  extends NoSuchElementException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNotFoundEception(Long patientId) {
		super(MessageFormat.format("Could not find patient with id: {0}", patientId));
	}

}
