package boot_microservice.boot_microservice.mockito.learn;

public interface EmailService {

	public void sendEmail(String email, String content);
	public SendMessage sendEmailAndRetrunMessage(String email, String content);
}
