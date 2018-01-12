package boot_microservice.boot_microservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import boot_microservice.boot_microservice.mockito.learn.EmailServiceImpl;
import boot_microservice.boot_microservice.mockito.learn.SendMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	private EmailServiceImpl emailService;

	String email;
	String content;
	SendMessage messageMock;
	
	@Before
	public void setUp(){
		 email="rrr@x.pl";
		 content="dupa";
		 messageMock= new SendMessage("1", content, 999);
	}
	
	@Test
	public void testSendEmail() {

	SendMessage response =	emailService.sendEmailAndRetrunMessage(email, content);	
	assertNotNull(response); 
	Assert.isInstanceOf(SendMessage.class, response);
	assertEquals(messageMock.getContent(),response.getContent());
	assertEquals(messageMock.getId(), response.getId());
	
	}

}
