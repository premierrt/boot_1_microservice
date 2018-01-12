package boot_microservice.boot_microservice.mockito.learn;
/**
 * http://www.baeldung.com/current-date-time-and-timestamp-in-java-8
 * @author rafal
 *
 */
public class SendMessage {
	
	private String id;
	private String content;
	private long timeStampMillis;
	
	
	
	
	public SendMessage(String id, String content, long timeStampMillis) {
		super();
		this.id = id;
		this.content = content;
		this.timeStampMillis = timeStampMillis;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getTimeStampMillis() {
		return timeStampMillis;
	}
	public void setTimeStampMillis(long timeStampMillis) {
		this.timeStampMillis = timeStampMillis;
	}

	@Override
	public String toString() {
		return "SendMessage [id=" + id + ", content=" + content + ", timeStampMillis=" + timeStampMillis + "]";
	}
	
	

}
