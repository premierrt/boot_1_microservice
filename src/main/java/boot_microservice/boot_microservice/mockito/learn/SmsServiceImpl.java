package boot_microservice.boot_microservice.mockito.learn;

import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

	public void sendSms(String phoneNumber, String content) {
		System.out.println(phoneNumber+ "   "+content);
	}

}
