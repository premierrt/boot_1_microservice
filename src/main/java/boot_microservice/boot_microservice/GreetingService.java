package boot_microservice.boot_microservice;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public  String greet(){
		return "hello!";
	}
	
}
