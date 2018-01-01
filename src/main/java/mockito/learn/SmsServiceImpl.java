package mockito.learn;

public class SmsServiceImpl implements SmsService {

	public void sendSms(String phoneNumber, String content) {
		System.out.println(phoneNumber+ "   "+content);
	}

}
