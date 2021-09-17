package surgery.surgerywaitinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/surgerywaitinglist")
public class WaitingListController {

	@Autowired
	private WaitingListService waitingListService;

	
	
	
	public List<WaitingList> waitingListgetAll() {
		return waitingListService.waitingListgetAll();
	}

	public WaitingList waitingListGetOne(Long waitingListId) {
		return waitingListService.waitingListGetOne(waitingListId);
	}

	public WaitingList addToWaitingList(WaitingList surgery) {
		return waitingListService.AddToWaitingList(surgery);
	}

	public WaitingList removeFromWaitingList(WaitingList surgery) {
		return waitingListService.removeFromWaitingList(surgery);
	}
}
