package vzateychuk.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vzateychuk.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/health")
public class HealthController {
    private static final Logger log = LoggerFactory.getLogger(HealthController.class);

    @Autowired private BuildProperties buildProperties;
    @Autowired private UserService userService;

    @GetMapping({"/live", "/live/"})
    public ResponseEntity<String> liveness() {
        log.info("/liveness invoked");
        return ResponseEntity.of(Optional.of("I'm alive!"));
    }

    @GetMapping({"/ready", "/ready/"})
    public ResponseEntity<String> readiness() {
        log.info("/readiness invoked");
        try {
            String userVer = userService.getVersion();
            String postVer = buildProperties.getVersion();
            String resp = String.format("Post-service: %s, User-service: %s\n", postVer, userVer);
            return ResponseEntity.of( Optional.of(resp) );
        } catch (Exception ex) {
            log.warn("service not ready", ex);
            return ResponseEntity.internalServerError().body("service not ready");
        }
    }
}
