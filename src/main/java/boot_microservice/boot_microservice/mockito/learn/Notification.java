package boot_microservice.boot_microservice.mockito.learn;

public class Notification {
	
	private String email;
	private String phoneNumber;
	private String content;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(String email, String phoneNumber, String content) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.content = content;
	}
	
	

}
