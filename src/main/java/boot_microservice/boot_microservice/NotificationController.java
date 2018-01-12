package boot_microservice.boot_microservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boot_microservice.boot_microservice.mockito.learn.Notification;

/**
 * ma zwracac jsona z NotificationVO
 * i przyjmowac na wejscu tez jakis obiekt z wywolania restAPi 
 * @author rafal
 *
 */
@RestController
public class NotificationController {
	/**
	 * 
	 * 
	 * {
"email":"rrr@dssdf.pl",
"phoneNumber":"666",
"content":"to jest tresc"
}
dodac naglowek conten-type = application/json
	 * @param notification
	 * @return
	 */
	@RequestMapping(value="/notify", method=RequestMethod.POST )
	public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification){
		
		//tutaj wolaj uslugi do wysylkis
		return new ResponseEntity<Notification>(notification, HttpStatus.OK);
		
		
	}
	
	
}
