package surgery.surgerywaitinglist.exception;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public class WaitingListNotFoundException extends NoSuchElementException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WaitingListNotFoundException(Long waitingListId) {
		super(MessageFormat.format("Could not find waitinlist with id: {0}", waitingListId));
	}

}
