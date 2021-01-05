package si.fri.rso.recepti.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import si.fri.rso.recepti.models.view.Komentar;
import si.fri.rso.recepti.models.view.Slika;

@Component
public class MSCallsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSlikeService",
            commandProperties = {
                    // Timeout, when circuit is closed (= wait 2 seconds)
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // Number of requests we are looking in a sleep window
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    // If 50% of looked in request fails, the circuit breaks (meaning 3 or more fails)
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // How long the circuit is broken
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Slika findSlikaByReceptId(Integer receptId) {
        return restTemplate.getForObject("http://slike-service/v1/slike/recept/" + receptId, Slika.class);
    }

    @HystrixCommand(fallbackMethod = "fallbackKomentarjiService",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Komentar[] findKomentaryByReceptId(Integer receptId) {
        ResponseEntity<Komentar[]> response =
                restTemplate.getForEntity("http://komentarji-service/v1/komentarji/recept/" + receptId, Komentar[].class);
        return response.getBody();
    }

    @HystrixCommand(fallbackMethod = "fallbackDeleteSlike",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Boolean deleteSlikeByReceptId(Integer receptId) {
        restTemplate.delete("http://slike-service/v1/slike/delete/recept/" + receptId);
        return true;
    }

    @HystrixCommand(fallbackMethod = "fallbackDeleteKomentarji",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Boolean deleteKomentarjiByReceptId(Integer receptId) {
        restTemplate.delete("http://komentarji-service/v1/komentarji/delete/recept/" + receptId);
        return true;
    }

    public Boolean fallbackDeleteSlike(Integer receptId) {
        return false;
    }

    public Boolean fallbackDeleteKomentarji(Integer receptId) {
        return false;
    }

    public Slika fallbackSlikeService(Integer receptId) {
        return null;
    }

    public Komentar[] fallbackKomentarjiService(Integer receptId) {
        return null;
    }

}
