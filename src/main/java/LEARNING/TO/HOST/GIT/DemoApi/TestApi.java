package LEARNING.TO.HOST.GIT.DemoApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
	
	@GetMapping("/getName")
	public Object getName() {
		
		String s = "{\r\n"
				+ "  \"Christopher Nolan\": \"Inception\",\r\n"
				+ "  \"Quentin Tarantino\": \"Pulp Fiction\",\r\n"
				+ "  \"Alfred Hitchcock\": \"Psycho\",\r\n"
				+ "  \"Steven Spielberg\": \"Jurassic Park\",\r\n"
				+ "  \"Greta Gerwig\": \"Barbie\",\r\n"
				+ "  \"Martin Scorsese\": \"Goodfellas\",\r\n"
				+ "  \"Denis Villeneuve\": \"Dune\",\r\n"
				+ "  \"Stanley Kubrick\": \"2001: A Space Odyssey\",\r\n"
				+ "  \"Jordan Peele\": \"Get Out\",\r\n"
				+ "  \"Hayao Miyazaki\": \"Spirited Away\"\r\n"
				+ "}";
		return s;
	}

}
