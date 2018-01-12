package boot_microservice.boot_microservice.mockito.learn;

import java.time.Instant;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	public void sendEmail(String email, String content) {

		System.out.println(email + " " +content);
	}

	@Override
	public SendMessage sendEmailAndRetrunMessage(String email, String content) {
		// TODO Auto-generated method stub
		System.out.println(email + " " +content);
		Instant instant = Instant.now();
		
		return new SendMessage("1",content, instant.getEpochSecond());
	}
	
	

}
