/***
 * https://spring.io/guides/gs/testing-web/
 */

package boot_microservice.boot_microservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {


	@Autowired
	HeartBeatController hBcontroller;
	
	@Test
	public void contextTest(){
		assertNotNull(hBcontroller);
		
	}
	
	

}
