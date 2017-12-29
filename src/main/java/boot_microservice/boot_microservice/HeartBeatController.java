package boot_microservice.boot_microservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roshanalwis on 9/30/17.
 */

@RestController
public class HeartBeatController {
    @RequestMapping(value = "/heartBeat", method = RequestMethod.GET)
    public ResponseEntity<String> heartBeat(){
        return new ResponseEntity<String>("ACK", HttpStatus.OK);
    }
}
