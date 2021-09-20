package surgery.surgerywaitinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surgery.surgerywaitinglist.entity.Surgeon;
import surgery.surgerywaitinglist.repository.SurgeonRepository;

@Service
public class SurgeonService {

	@Autowired
	private SurgeonRepository surgeonRepo;

	public List<Surgeon> surgeonGetAll() {
		return surgeonRepo.findAll();
	
	}

	public Surgeon surgeonGetOne(Long surgeonId) {
		//exception to be added here :)
		return surgeonRepo.findById(surgeonId).get();
	}

	public Surgeon addSurgeon(Surgeon surgeon) {
		return surgeonRepo.save(surgeon);
	}

	public Surgeon removeSurgeon(Long surgeonId) {
		Surgeon surgeon = surgeonGetOne(surgeonId);
		surgeonRepo.delete(surgeon);
		return surgeon;
	}
	
	
}
