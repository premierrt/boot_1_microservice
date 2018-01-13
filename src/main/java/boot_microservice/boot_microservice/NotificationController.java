package boot_microservice.boot_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boot_microservice.boot_microservice.mockito.learn.Notification;
import boot_microservice.boot_microservice.mockito.learn.NotificationService;

/**
 * ma zwracac jsona z NotificationVO
 * i przyjmowac na wejscu tez jakis obiekt z wywolania restAPi 
 * @author rafal
 *
 */
@RestController
public class NotificationController {
	
	
	private NotificationService notificationService;
	
	
	/**
	 * wstrzyknięcie przez konstruktor - bezpieczniejsze i lepiej testowalne
	 * https://stormpath.com/blog/5-practical-tips-for-building-your-spring-boot-api
	 * @param notificationService
	 */
	@Autowired
	public NotificationController(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}




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
		
		notificationService.sendNotification(notification.getEmail(), notification.getContent());
		
		return new ResponseEntity<Notification>(notification, HttpStatus.OK);
		
		
	}
	
	
}
