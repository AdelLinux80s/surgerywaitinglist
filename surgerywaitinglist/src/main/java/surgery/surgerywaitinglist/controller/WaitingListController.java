package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import surgery.surgerywaitinglist.entity.WaitingList;
import surgery.surgerywaitinglist.service.WaitingListService;

@RestController
@RequestMapping("/surgerywaitinglist")
public class WaitingListController {

	@Autowired
	private WaitingListService waitingListService;

	@GetMapping
	public List<WaitingList> waitingListgetAll() {
		return waitingListService.waitingListgetAll();
	}

	@GetMapping(value="{waitingListId}")
	public WaitingList waitingListGetOne(@PathVariable Long waitingListId) {
		return waitingListService.waitingListGetOne(waitingListId);
	}

	@PostMapping
	public WaitingList addCaseToWaitingList(@RequestBody WaitingList surgery) {
		return waitingListService.addCaseToWaitingList(surgery);
	}

	@DeleteMapping(value="{waitingListId}")
	public WaitingList removeCaseFromWaitingList(@PathVariable Long waitingListId) {
		return waitingListService.removeCaseFromWaitingList(waitingListId);
	}

	@PutMapping(value="{waitingListId}/patient/{patientId}/set-patient")
	public WaitingList setPatientToWaitingList(@PathVariable Long patientId, @PathVariable Long waitingListId) {
		return waitingListService.setPatientToWaitingList(patientId, waitingListId);
	}

	
	@PutMapping(value="{waitingListId}/unset-patient")
	public WaitingList unsetPatientFromWaitingList(@PathVariable Long waitingListId) {
		return waitingListService.unsetPatientFromWaitingList(waitingListId);
	}
	
	@PutMapping(value="{waitingListId}/surgeon/{surgeonId}/set-surgeon")
	public WaitingList setSurgeonToWaitingList(@PathVariable Long surgeonId, @PathVariable Long waitingListId) {
		return waitingListService.setSurgeonToWaitingList(surgeonId, waitingListId);
	}
	
	
	@PutMapping(value="{waitingListId}/unset-surgeon")
	public WaitingList unsetSurgeonFromWaitingList( @PathVariable Long waitingListId) {
		return waitingListService.unsetSurgeonToWaitingList( waitingListId);
	}
	
	
}
