package vzateychuk.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping({"", "/", "/greeting", "/greeting/"})
    public String greeting() {
        log.info("/greeting invoked");
        return "UserService says: Hello, k8s!";
    }
}
