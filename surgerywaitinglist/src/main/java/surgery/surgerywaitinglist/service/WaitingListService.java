package surgery.surgerywaitinglist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Surgeon;
import surgery.surgerywaitinglist.entity.WaitingList;
import surgery.surgerywaitinglist.repository.WaitingListRepository;

@Service
public class WaitingListService {

	@Autowired
	private WaitingListRepository waitingListRepo;
	@Autowired
	private SurgeonService surgeonService;

	public List<WaitingList> waitingListgetAll() {
		return waitingListRepo.findAll();
	}

	public WaitingList waitingListGetOne(Long waitingListId) {
		
		// exception to be added here :)
		return waitingListRepo.findById(waitingListId).get();
	}

	public WaitingList addCaseToWaitingList(WaitingList surgery) {
		return waitingListRepo.save(surgery);
	}

	public WaitingList removeCaseFromWaitingList(Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingListRepo.delete(waitingList);
		return waitingList;
	}

	@Transactional
	public WaitingList setPatientToWaitingList(Long patientId, Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingList.setWaitingListPatientId(patientId);
		
		return waitingList;
	}

	@Transactional
	public WaitingList unsetPatientFromWaitingList(Long patientId, Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingList.setWaitingListPatientId(null);
		return waitingList;
	}

	@Transactional
	public WaitingList setSurgeonToWaitingList(Long surgeonId, Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
		waitingList.setWaitingListSurgeonId(surgeonId);
		waitingList.setWaitingListDepartmentId(surgeon.getDepartmentIdInSurgery());
		return waitingList;
	}

	@Transactional
	public WaitingList unsetSurgeonToWaitingList(Long surgeonId, Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingList.setWaitingListSurgeonId(null);
		waitingList.setWaitingListDepartmentId(null);
		return waitingList;
	}
	
	
	
}
