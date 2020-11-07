package si.fri.rso.recepti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("si.fri.rso.recepti.repositories")
public class ReceptiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceptiServiceApplication.class, args);
	}

}
