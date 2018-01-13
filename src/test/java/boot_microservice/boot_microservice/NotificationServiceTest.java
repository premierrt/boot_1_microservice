package boot_microservice.boot_microservice;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import boot_microservice.boot_microservice.mockito.learn.EmailService;
import boot_microservice.boot_microservice.mockito.learn.NotificationService;
import boot_microservice.boot_microservice.mockito.learn.NotificationServiceImplAdvanced;
import boot_microservice.boot_microservice.mockito.learn.SendMessage;
import boot_microservice.boot_microservice.mockito.learn.SmsService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class NotificationServiceTest {
	
	
	private NotificationService notificationService;

	private String content;
	private long timestamp;
	
	@Mock
	private EmailService email;
	
	@Mock
	private SmsService smsService;
	
	@Before
	public void setUp(){
		content= "dupa";
		timestamp= 666;
		notificationService = new NotificationServiceImplAdvanced(email, smsService);
	}
	
	@Test
	public void test() {
		// email jest zamkowanym serwisem wstrzyknietym do notificationService
		//każde wywołanie metody email.sendEmailAndRetrunMessage w nofifcationService będzie zwracało obiekt SendMessage jak niżej
		when(email.sendEmailAndRetrunMessage(anyString(), anyString())).thenReturn(new SendMessage("1", "mock", 666));
		
		assertNotNull(notificationService.sendNotification("dupa", content));
		//wywołuje notificationService ktore wywola zamokckowany wyzej email service (ktor zwraca zamokowane dane)
		assertEquals(timestamp, notificationService.sendNotification("dupa", content).getTimeStampMillis());
	}

}
