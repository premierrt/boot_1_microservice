package mockito.learn;

public class EmailServiceImpl implements EmailService {

	public void sendEmail(String email, String content) {

		System.out.println(email + " " +content);
	}

}
