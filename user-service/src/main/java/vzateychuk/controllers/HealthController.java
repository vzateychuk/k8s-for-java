package vzateychuk.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/health")
public class HealthController {
    private static final Logger log = LoggerFactory.getLogger(HealthController.class);

    @Autowired private BuildProperties buildProperties;

    @GetMapping({"/live", "/live/"})
    public ResponseEntity<String> liveness() {
        log.info("/liveness invoked");
        return new ResponseEntity<>("I'm alive!", HttpStatus.OK);
    }

    @GetMapping({"/ready", "/ready/"})
    public ResponseEntity<String> readiness() {
        log.info("/readiness invoked");
        return ResponseEntity.of(
                Optional.of("UserService ver: {}" + buildProperties.getVersion())
        );
    }
}
