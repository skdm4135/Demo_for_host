package DemoApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
	
	@GetMapping("/getName")
	public String getName() {
		return "Sumit Yadav";
	}

}
