package vzateychuk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vzateychuk.model.PostEntity;
import vzateychuk.repo.PostRepo;

import java.time.LocalDate;

@Configuration
public class PreLoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(PreLoadDatabase.class);

    @Bean
    CommandLineRunner preload(PostRepo PostRepo) {

        return args -> {
            log.info( "Preload " + PostRepo.save(
                    new PostEntity(null, 1L, "Bilbo Baggins open the door", LocalDate.now()))
            );
            log.info("Preload " + PostRepo.save(
                    new PostEntity(null, 2L, "Frodo Baggins says hello", LocalDate.now()))
            );
            log.info("Preload " + PostRepo.save(
                    new PostEntity(null, 3L, "Gendalf Gray wrote this book", LocalDate.now()))
            );
        };
    }
}
