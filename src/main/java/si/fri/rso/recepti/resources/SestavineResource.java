package si.fri.rso.recepti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.fri.rso.recepti.models.Sestavina;
import si.fri.rso.recepti.repositories.SestavineRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sestavine")
public class SestavineResource {

    @Autowired
    private SestavineRepository sestavineRepository;

    @GetMapping
    public List<Sestavina> getSestavine() {
        return sestavineRepository.findAll();
    }

    @GetMapping("/{sestavinaId}")
    public Optional<Sestavina> getSestavinaById(@PathVariable("sestavinaId") Integer sestavinaId) {
        return sestavineRepository.findById(sestavinaId);
    }

    @PutMapping("/update/{sestavinaId}")
    public Sestavina updateSestavina(@RequestBody Sestavina sestavina, @PathVariable("sestavinaId") Integer sestavinaId) {

        Optional<Sestavina> sestavinaToUpdate = sestavineRepository.findById(sestavinaId);

        return sestavinaToUpdate.map(s -> {
            s.setRecept(s.getRecept());
            s.setEnotaKolicine(sestavina.getEnotaKolicine());
            s.setIme(sestavina.getIme());
            s.setKolicina(sestavina.getKolicina());
            return sestavineRepository.save(s);
        }).orElseGet(() -> {
            sestavina.setSestavinaId(sestavinaId);
            sestavina.setCreated(LocalDate.now());
            return sestavineRepository.save(sestavina);
        });
    }

    @DeleteMapping("/delete/{sestavinaId}")
    public void deleteSestavina(@PathVariable("sestavinaId") Integer sestavinaId) {
        sestavineRepository.deleteById(sestavinaId);
    }

}
