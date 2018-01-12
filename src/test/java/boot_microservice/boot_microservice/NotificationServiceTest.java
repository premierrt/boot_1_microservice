package boot_microservice.boot_microservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import boot_microservice.boot_microservice.mockito.learn.EmailService;
import boot_microservice.boot_microservice.mockito.learn.NotificationService;
import boot_microservice.boot_microservice.mockito.learn.NotificationServiceImpl;
import boot_microservice.boot_microservice.mockito.learn.SmsService;

public class NotificationServiceTest {
	
	
	private NotificationService notificationService;

	
	@Mock
	private EmailService email;
	
	@Mock
	private SmsService smsService;
	
	@Before
	public void setUp(){
		notificationService = new NotificationServiceImpl(email, smsService);
	}
	
	@Test
	public void test() {
		
	//	noti.sendNotification(mail, phoneNumber, notifcationContent);
	
	}

}
