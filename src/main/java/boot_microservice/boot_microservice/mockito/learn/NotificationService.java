package boot_microservice.boot_microservice.mockito.learn;

import java.util.Optional;

/**
 * https://kobietydokodu.pl/niezbednik-juniora-mockito/
 * @author rafal
 *
 */
public interface NotificationService {
	public String sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent);
	public SendMessage sendNotification(String mail, String notifcationContent);
}
