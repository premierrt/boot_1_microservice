package boot_microservice.boot_microservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import mockito.learn.EmailService;
import mockito.learn.NotificationService;

public class NotificationServiceTest {
	
	@Autowired
	private NotificationService noti;

	
	@Mock
	private EmailService email;
	
	
	@Test
	public void test() {
		
	//	noti.sendNotification(mail, phoneNumber, notifcationContent);
	
	}

}
