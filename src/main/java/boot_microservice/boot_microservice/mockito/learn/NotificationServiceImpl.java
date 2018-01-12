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
public class NotificationServiceImpl implements NotificationService {

	
	
	
	public NotificationServiceImpl(EmailService email, SmsService sms) {
		super();
		this.email = email;
		this.sms = sms;
	}

	@Autowired
	private EmailService email;
	
	@Autowired
	private SmsService sms; 
	
	public void sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent) {

		mail.ifPresent(value -> email.sendEmail(value, notifcationContent));
		phoneNumber.ifPresent(value-> sms.sendSms(value, notifcationContent));
	}
	
	

}
