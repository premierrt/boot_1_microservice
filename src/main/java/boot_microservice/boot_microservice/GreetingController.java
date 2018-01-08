package boot_microservice.boot_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	
@Autowired	
private GreetingService greetingService;	

@RequestMapping(value="/greeting", method=RequestMethod.GET)
public ResponseEntity<String> greet (){
	return new ResponseEntity<String>(greetingService.greet(), HttpStatus.OK );
}

}
