package LEARNING.TO.HOST.GIT.DemoApi;

import java.util.Map;

import org.json.JSONObject;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class WeatherApp {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherApp.class);
	
	@GetMapping("/getWeather")
	public Map<String,Object> getWeatherDetails(@RequestParam("city") String city){
		
		
		logger.info("====== ENTERED INTO WEATHER API ======");
		
		String baseUrl = "http://api.weatherapi.com/v1/current.json";
		
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                              .queryParam("key","ba001fdbe8fd4416842192617253110")
                              .queryParam("q",city)
                              .toUriString();
		
		logger.info("==== weather url ::::: " + url);
		
		JSONObject finalResponse = new JSONObject();
		
		try {
			
			ResponseEntity<String> response = restTemplate.exchange
					(url,HttpMethod.GET,null,String.class);
			
			logger.info("=== STATUS CODE FROM WEATHER API ::::::::::: " + response.getStatusCode());
			
			logger.info("==== RESPONSE COMING FROM THIRD PARTY URL ::::: "  +  response.getBody());
			
			
			finalResponse.put("Resposne", new JSONObject(response.getBody()));
			finalResponse.put("StatusCode", response.getStatusCode());
			
		}catch(Exception e) {
			
			logger.info("==== ERROR RESPONSE WHILE HITTING 3RD PARTY URL :::: " + e);
			
			
			finalResponse.put("Response", "Error Received :: " + e.getMessage());
			finalResponse.put("StatusCode", "99");
		}
		
		return finalResponse.toMap();
		
	}

}
