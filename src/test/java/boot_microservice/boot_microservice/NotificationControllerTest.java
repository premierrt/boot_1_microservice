package boot_microservice.boot_microservice;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import boot_microservice.boot_microservice.mockito.learn.Notification;
import boot_microservice.boot_microservice.mockito.learn.NotificationServiceImplAdvanced;
import boot_microservice.boot_microservice.mockito.learn.NotificationServiceImplBasic;
import boot_microservice.boot_microservice.mockito.learn.SendMessage;


/**
 * https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/
 * @author rafal
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NotificationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private NotificationServiceImplAdvanced notificationServiceImplAdvanced;
	
	@Mock
	private NotificationServiceImplBasic notificationServiceImplBasic;
	
	/**
	 * wstrzykuje mocki do servicu
	 */
	@InjectMocks
	private NotificationController notificationController;
	
	@Test
	public void testNoArgumentsRestCall() throws Exception{
		SendMessage sm = new SendMessage("88", "mockito test ", 999);
		when(notificationServiceImplBasic.sendNotification(any(String.class), any(String.class))).thenReturn(sm);
		when(notificationServiceImplAdvanced.sendNotification(any(String.class), any(String.class))).thenReturn(sm);

		mockMvc.perform(post("/basicNotify")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testRestCall() throws Exception{
		SendMessage sm = new SendMessage("88", "mockito test ", 999);
		when(notificationServiceImplBasic.sendNotification(any(String.class), any(String.class))).thenReturn(sm);
		when(notificationServiceImplAdvanced.sendNotification(any(String.class), any(String.class))).thenReturn(sm);

		String phoneNumber="777888999";
		Notification notifcation = new Notification("mockit@email",phoneNumber , "parametr wejsciowy mockito");
		mockMvc.perform(
				post("/basicNotify")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(new ObjectMapper().writeValueAsString(notifcation))
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email",is("mockit@email")))
		;
		
//		if (phoneNumber.length() <5)
//			verify(notificationServiceImplBasic, times(1)).sendNotification(any(String.class), any(String.class));
//		else
//			verify(notificationServiceImplAdvanced, times(1)).sendNotification(any(String.class), any(String.class));
//	
		verifyNoMoreInteractions(notificationServiceImplAdvanced);
		verifyNoMoreInteractions(notificationServiceImplBasic);
		
	}
}
