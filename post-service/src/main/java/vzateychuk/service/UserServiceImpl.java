package vzateychuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.service.api}") private String userAPI;

    @Override
    public String getVersion() {
        ResponseEntity<String> resp = restTemplate.getForEntity(userAPI + "/health/ready" , String.class);
        if (resp.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("User service not ready");
        }
        return  resp.getBody();
    }
}
