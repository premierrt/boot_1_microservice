package boot_microservice.boot_microservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boot_microservice.boot_microservice.mockito.learn.Notification;
import boot_microservice.boot_microservice.mockito.learn.NotificationService;
import boot_microservice.boot_microservice.mockito.learn.NotificationServiceImplAdvanced;
import boot_microservice.boot_microservice.mockito.learn.SendMessage;

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
	public NotificationController(NotificationServiceImplAdvanced notificationService) {
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
	
	
	/**
	 * implementacja wzorca strategy w spring
	 * https://stackoverflow.com/questions/17629761/strategy-pattern-with-spring-beans
	 * https://stackoverflow.com/questions/32715156/inject-values-into-map-using-spring-annotation
	 */
	
	@Autowired
	private Map<String, NotificationService> notificationServices = new HashMap<>();
	
	@RequestMapping(value="/basicNotify", method=RequestMethod.POST )
	public ResponseEntity<Notification> sendBasicNotification(@RequestBody Notification notification){
		SendMessage sm;
		
		//wybór strategii z hash mapy - moze tu byc if w zaleznosci od paremetru wywolania 
		if (notification.getPhoneNumber().length() <5)
			 sm= notificationServices.get("notificationServiceImplBasic").sendNotification(notification.getEmail(), notification.getContent());
		else
			 sm= notificationServices.get("notificationServiceImplAdvanced").sendNotification(notification.getEmail(), notification.getContent());

		notification.setContent(sm.getContent());
		return new ResponseEntity<Notification>(notification, HttpStatus.OK);

	}
	
	
	
}
