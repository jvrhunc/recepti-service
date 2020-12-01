package si.fri.rso.recepti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import si.fri.rso.recepti.models.Recept;
import si.fri.rso.recepti.models.Sestavina;
import si.fri.rso.recepti.models.enums.Tip;
import si.fri.rso.recepti.repositories.ReceptiRepository;
import si.fri.rso.recepti.repositories.SestavineRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/recepti")
@RefreshScope
public class ReceptiResource {

    @Autowired
    private ReceptiRepository receptiRepository;

    @Autowired
    private SestavineRepository sestavineRepository;

    @Value("${my.greeting:test}")
    private String greeting;

    @GetMapping
    public List<Recept> getRecepti(@RequestParam(required = false, name = "tip") Tip tip) {
        if (tip == null) {
            return receptiRepository.findAll();
        } else {
            return receptiRepository.findByTip(tip);
        }
    }

    @GetMapping("/{receptId}")
    public Optional<Recept> getReceptById(@PathVariable("receptId") Integer receptId) {
        return receptiRepository.findById(receptId);
    }

    @PostMapping("/add")
    public Recept addRecept(@RequestBody Recept recept) {

        for (Sestavina sestavina : recept.getSestavine()) {
            sestavina.setCreated(LocalDate.now());
            sestavina.setRecept(recept);
        }
        recept.setCreated(LocalDate.now());
        return receptiRepository.save(recept);
    }

    @DeleteMapping("/delete/{receptId}")
    public void deleteRecept(@PathVariable("receptId") Integer receptId) {
        receptiRepository.deleteById(receptId);
    }

    @PutMapping("/update/{receptId}")
    public Recept updateRecept(@RequestBody Recept recept, @PathVariable("receptId") Integer receptId) {
        Optional<Recept> receptToUpdate = receptiRepository.findById(receptId);

        return receptToUpdate.map(r -> {
            r.setIme(recept.getIme());
            r.setOpis(recept.getOpis());
            r.setUporabnikId(recept.getUporabnikId());
            r.setTip(recept.getTip());
            r.setSestavine(receptToUpdate.get().getSestavine());
            return receptiRepository.save(r);
        }).orElseGet(() -> {
            recept.setReceptId(receptId);
            return receptiRepository.save(recept);
        });
    }

    @GetMapping("/{receptId}/sestavine")
    public List<Sestavina> getSestavineByRecept(@PathVariable("receptId") Integer receptId) {
        Optional<Recept> recept = receptiRepository.findById(receptId);
        return recept.map(value -> sestavineRepository.getByRecept(value)).orElse(null);
    }

    @PostMapping("/{receptId}/sestavine/add")
    public Sestavina addSestavina(@PathVariable("receptId") Integer receptId, @RequestBody Sestavina sestavina) {
        Optional<Recept> recept = receptiRepository.findById(receptId);
        if (recept.isPresent()) {
            sestavina.setRecept(recept.get());
            sestavina.setCreated(LocalDate.now());
            return sestavineRepository.save(sestavina);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/sestavine/{sestavinaId}")
    public void deleteSestavina(@PathVariable("sestavinaId") Integer sestavinaId) {
        sestavineRepository.deleteById(sestavinaId);
    }

    @PutMapping("/update/sestavine/{sestavinaId}")
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

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting;
    }
}
