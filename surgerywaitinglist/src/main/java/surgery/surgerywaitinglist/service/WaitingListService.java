package surgery.surgerywaitinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.WaitingList;
import surgery.surgerywaitinglist.repository.WaitingListRepository;

@Service
public class WaitingListService {

	@Autowired
	private WaitingListRepository waitingListRepo;

	public List<WaitingList> waitingListgetAll() {
		return waitingListRepo.findAll();
	}

	public WaitingList waitingListGetOne(Long waitingListId) {
		
		// exception to be added here :)
		return waitingListRepo.findById(waitingListId).get();
	}

	public WaitingList AddToWaitingList(WaitingList surgery) {
		return waitingListRepo.save(surgery);
	}

	public WaitingList removeFromWaitingList(Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingListRepo.delete(waitingList);
		return waitingList;
	}

	public WaitingList addPatientToWaitingList(Long patientId, Long waitingListId) {
		//to be added 
		return null;
	}
	
	
	
}
