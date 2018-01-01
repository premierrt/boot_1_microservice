package mockito.learn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * dodac wzorzec strategy
 * @author rafal
 *
 */
public class NotificationServiceImpl implements NotificationService {

	
	@Autowired
	private EmailService email;
	
	@Autowired
	private SmsService sms; 
	
	public void sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent) {

		mail.ifPresent(value -> email.sendEmail(value, notifcationContent));
		phoneNumber.ifPresent(value-> sms.sendSms(value, notifcationContent));
	}

}
