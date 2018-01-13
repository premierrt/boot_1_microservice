package boot_microservice.boot_microservice.mockito.learn;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImplBasic implements NotificationService{

	@Override
	public String sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent) {
		// TODO Auto-generated method stub
		return "wyslano wiadomosc basic";
	}

	@Override
	public SendMessage sendNotification(String mail, String notifcationContent) {
		// TODO Auto-generated method stub
		return new SendMessage("44", notifcationContent, 8888);
	}

}
