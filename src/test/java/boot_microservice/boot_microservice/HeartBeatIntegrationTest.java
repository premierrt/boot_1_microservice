package boot_microservice.boot_microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeartBeatIntegrationTest {

	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
	
	
	
	@Test
	public void ackShould() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/heartBeat", String.class))
		.contains("ACK");
	}

}
