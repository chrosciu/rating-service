package eu.chrost.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RatingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RatingApplication.class, args);
    }
}
