package mockito.learn;

import java.util.Optional;

/**
 * https://kobietydokodu.pl/niezbednik-juniora-mockito/
 * @author rafal
 *
 */
public interface NotificationService {
	public void sendNotification(Optional<String> mail, Optional<String> phoneNumber, String notifcationContent);
}
