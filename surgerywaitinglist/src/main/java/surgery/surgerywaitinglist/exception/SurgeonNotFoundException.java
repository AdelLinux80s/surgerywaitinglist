package surgery.surgerywaitinglist.exception;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class SurgeonNotFoundException extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurgeonNotFoundException(Long surgeonId) {
		super(MessageFormat.format("Could not find surgeon with id: {0}", surgeonId));
	}
}
