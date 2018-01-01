package boot_microservice.boot_microservice;

import org.springframework.stereotype.Service;

/**
 * do testow kontrolera GreetingControler
 * @author rafal
 *
 */
@Service
public class GreetingService {

	public  String greet(){
		return "hello!";
	}
	
}
