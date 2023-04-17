package vzateychuk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vzateychuk.model.UserEntity;
import vzateychuk.repo.UserRepo;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepo userRepo) {

        return args -> {
            log.info( "Preload " + userRepo.save(new UserEntity( "Bilbo Baggins", 0)));
            log.info("Preload " + userRepo.save(new UserEntity( "Frodo Baggins", 0)));
            log.info("Preload " + userRepo.save(new UserEntity( "Gendalf Gray", 0)));
        };
    }
}
