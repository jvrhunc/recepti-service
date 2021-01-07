package si.fri.rso.recepti.resources;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.fri.rso.recepti.models.entities.Recept;
import si.fri.rso.recepti.models.entities.Sestavina;
import si.fri.rso.recepti.models.view.ReceptItem;
import si.fri.rso.recepti.models.view.Uporabnik;
import si.fri.rso.recepti.services.ReceptiService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/recepti")
@RefreshScope
@CrossOrigin("*")
public class ReceptiResource {

    @Autowired
    private ReceptiService receptiService;

    @Timed(
            value = "Recepti.getAll",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @GetMapping
    public ResponseEntity<Object> getRecepti() {
        return ResponseEntity.status(HttpStatus.OK).body(receptiService.getRecepti());
    }

    @Timed(
            value = "Recepti.getById",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @GetMapping("/{receptId}")
    public ResponseEntity<Object> getReceptById(@PathVariable("receptId") Integer receptId) {
        if (receptId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept Id is required!");
        }

        ReceptItem recept = receptiService.getReceptById(receptId);

        if(recept == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(recept);
    }

    @Timed(
            value = "Recepti.save",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @PostMapping("/add/{uporabnikId}")
    public ResponseEntity<Object> addRecept(@RequestBody Recept recept,
                                            @PathVariable("uporabnikId") Integer uporabnikId) {
        if(uporabnikId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uporabnik id is required!");
        }

        if (recept == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept is required!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(receptiService.addRecept(recept, uporabnikId));
    }

    @Timed(
            value = "Recepti.delete",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @DeleteMapping("/delete/{receptId}")
    public ResponseEntity<Object> deleteRecept(@PathVariable("receptId") Integer receptId) {
        if (receptId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept Id is required!");
        }

        // Izbrisemo recept
        Boolean uspesno = receptiService.deleteRecept(receptId);
        if (uspesno) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Recept with id: " + receptId + "deleted!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while deleting Recept with Id: " + receptId);
    }

    @Timed(
            value = "Recepti.update",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @PutMapping("/update/{receptId}")
    public ResponseEntity<Object> updateRecept(@RequestBody Recept recept, @PathVariable("receptId") Integer receptId) {
        if (receptId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept Id is required!");
        }

        if (recept == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept is required!");
        }

        Recept updatedRecept = receptiService.updateRecept(recept, receptId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedRecept);
    }

    @Timed(
            value = "Recept.getSestavineByRecept",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @GetMapping("/{receptId}/sestavine")
    public ResponseEntity<Object> getSestavineByRecept(@PathVariable("receptId") Integer receptId) {
        if (receptId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept Id is required!");
        }

        List<Sestavina> sestavine = receptiService.getSestavineByRecept(receptId);
        if(sestavine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sestavine for recept with id: " + receptId + " not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(sestavine);
    }

    @Timed(
            value = "Recepti.saveSestavina",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @PostMapping("/{receptId}/sestavine/add")
    public ResponseEntity<Object> addSestavina(@PathVariable("receptId") Integer receptId, @RequestBody Sestavina sestavina) {
        if (receptId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recept Id is required!");
        }

        if (sestavina == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sestavina is required!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(receptiService.addSestavina(receptId, sestavina));
    }

    @Timed(
            value = "Recepti.deleteSestavina",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @DeleteMapping("/delete/sestavine/{sestavinaId}")
    public ResponseEntity<Object>  deleteSestavina(@PathVariable("sestavinaId") Integer sestavinaId) {
        if (sestavinaId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sestavina Id is required!");
        }

        Boolean uspesno = receptiService.deleteSestavina(sestavinaId);
        if (uspesno) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sestavina with id: " + sestavinaId + "deleted!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in deleting Sestavina by Id: " + sestavinaId);
    }

    @Timed(
            value = "Recepti.updateSestavina",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "v1"}
    )
    @PutMapping("/update/sestavine/{sestavinaId}")
    public ResponseEntity<Object> updateSestavina(@RequestBody Sestavina sestavina, @PathVariable("sestavinaId") Integer sestavinaId) {
        if (sestavinaId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sestavina Id is required!");
        }

        if (sestavina == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sestavina is required!");
        }

        Sestavina updateSestavina = receptiService.updateSestavina(sestavina, sestavinaId);

        return ResponseEntity.status(HttpStatus.OK).body(updateSestavina);
    }

    @GetMapping("/uporabniki")
    public List<Uporabnik> getUsers() {
        ArrayList<Uporabnik> uporabniks = new ArrayList<>();
        uporabniks.add(new Uporabnik(1, "Požrešni", "Medved", "greedyteddy",
                "https://www.animatedimages.org/data/media/1366/animated-brother-bear-image-0007.gif"));
        uporabniks.add(new Uporabnik(2, "Sladkosneda", "Veverica", "sugarsquirell",
                "https://webstockreview.net/images/clipart-houses-squirrel-12.png"));
        uporabniks.add(new Uporabnik(3, "Veseli", "Kuža", "happydoggo",
                "https://i.pinimg.com/originals/e9/0e/b6/e90eb68c08253983803788f3d8caf6b9.png"));
        return uporabniks;
    }

    /**
     * Mock implementacija uporabnikov
     * @param id
     * @return
     */
    @GetMapping("/uporabniki/{id}")
    public Uporabnik getUserById(@PathVariable("id") Integer id) {
        if (id == 1) {
            return new Uporabnik(1,"Požrešni","Medved","greedyteddy",
                    "https://www.animatedimages.org/data/media/1366/animated-brother-bear-image-0007.gif");
        } else if (id == 2) {
            return new Uporabnik(2,"Sladkosneda","Veverica","sugarsquirell",
                    "https://webstockreview.net/images/clipart-houses-squirrel-12.png");
        } else {
            return new Uporabnik(3,"Veseli","Kuža","happydoggo",
                    "https://i.pinimg.com/originals/e9/0e/b6/e90eb68c08253983803788f3d8caf6b9.png");
        }
    }
}
