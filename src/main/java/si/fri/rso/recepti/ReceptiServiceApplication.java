package si.fri.rso.recepti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import si.fri.rso.recepti.repositories.ReceptiRepository;
import si.fri.rso.recepti.repositories.SestavineRepository;
import si.fri.rso.recepti.resolvers.Query;

@SpringBootApplication
@EnableJpaRepositories("si.fri.rso.recepti.repositories")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ReceptiServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceptiServiceApplication.class, args);
	}

	@Bean
	public Query query(ReceptiRepository receptiRepository, SestavineRepository sestavineRepository) {
		return new Query(receptiRepository, sestavineRepository);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
