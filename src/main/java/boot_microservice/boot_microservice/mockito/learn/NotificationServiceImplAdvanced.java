package boot_microservice.boot_microservice.mockito.learn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * dodac wzorzec strategy
 * @author rafal
 *
 */
@Service
public class NotificationServiceImplAdvanced implements NotificationService {

	
	
	
	public NotificationServiceImplAdvanced(EmailService email, SmsService sms) {
		super();
		this.email = email;
		this.sms = sms;
	}

	@Autowired
	private EmailService email;
	
	@Autowired
	private SmsService sms; 
	
	public String sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent) {
		
		
		mail.ifPresent(value -> email.sendEmail(value, notifcationContent));
		phoneNumber.ifPresent(value-> sms.sendSms(value, notifcationContent));
		return notifcationContent;
	}
	
	public SendMessage sendNotification(String mail, String notifcationContent) {
		SendMessage sm=	email.sendEmailAndRetrunMessage(mail, notifcationContent);
		sm.setContent("advanced impl");
		System.out.println(sm.toString());
		return sm;
	}

}
