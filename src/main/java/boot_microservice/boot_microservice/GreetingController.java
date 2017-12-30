package boot_microservice.boot_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	
@Autowired	
private GreetingService greetingService;	

@RequestMapping(value="/greeting", method=RequestMethod.GET)
public @ResponseBody String greet (){
	return greetingService.greet();
}

}
