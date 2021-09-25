package surgery.surgerywaitinglist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Department;
import surgery.surgerywaitinglist.entity.Patient;
import surgery.surgerywaitinglist.entity.Surgeon;
import surgery.surgerywaitinglist.entity.WaitingList;
import surgery.surgerywaitinglist.exception.SurgeonNotAssignedToDepartment;
import surgery.surgerywaitinglist.exception.WaitingListNotFoundException;
import surgery.surgerywaitinglist.repository.WaitingListRepository;

@Service
public class WaitingListService {

	@Autowired
	private WaitingListRepository waitingListRepo;
	@Autowired
	private SurgeonService surgeonService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DepartmentService depService;

	public List<WaitingList> waitingListgetAll() {
		return waitingListRepo.findAll();
	}

	public WaitingList waitingListGetOne(Long waitingListId) {
		
		return waitingListRepo.findById(waitingListId).orElseThrow(() -> new WaitingListNotFoundException(waitingListId));
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
		Patient patient = patientService.patientGetOne(patientId) ;
		waitingList.setWaitingListPatientId(patient.getPatientId());
		
		return waitingList;
	}

	@Transactional
	public WaitingList unsetPatientFromWaitingList(Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingList.setWaitingListPatientId(null);
		return waitingList;
	}

	@Transactional
	public WaitingList setSurgeonToWaitingList(Long surgeonId, Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		Surgeon surgeon = surgeonService.surgeonGetOne(surgeonId);
		if(surgeon.getDepartmentIdInSurgery() == null) {
			throw new SurgeonNotAssignedToDepartment(surgeonId); 
		}
		
		Department department = depService.departmentGetOne(surgeon.getDepartmentIdInSurgery()) ;
		
		
		
		waitingList.setWaitingListSurgeonId(surgeonId);
		waitingList.setWaitingListDepartmentId(department.getDepartmentId());
		
		return waitingList;
	}

	@Transactional
	public WaitingList unsetSurgeonToWaitingList(Long waitingListId) {
		WaitingList waitingList =  waitingListGetOne(waitingListId);
		waitingList.setWaitingListSurgeonId(null);
		waitingList.setWaitingListDepartmentId(null);
		return waitingList;
	}
	
	
	
}
