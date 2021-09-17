package surgery.surgerywaitinglist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/index")
	public String getWelcome() {
		return "Welcome :)";
	}
}
