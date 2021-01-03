package si.fri.rso.recepti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import si.fri.rso.recepti.repositories.ReceptiRepository;
import si.fri.rso.recepti.repositories.SestavineRepository;

@SpringBootApplication
@EnableJpaRepositories("si.fri.rso.recepti.repositories")
@EnableDiscoveryClient
public class ReceptiServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceptiServiceApplication.class, args);
	}

	@Bean
	public Query query(ReceptiRepository receptiRepository, SestavineRepository sestavineRepository) {
		return new Query(receptiRepository, sestavineRepository);
	}
}
