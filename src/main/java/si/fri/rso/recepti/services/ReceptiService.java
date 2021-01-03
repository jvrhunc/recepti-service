package si.fri.rso.recepti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.fri.rso.recepti.models.Recept;
import si.fri.rso.recepti.models.Sestavina;
import si.fri.rso.recepti.models.enums.Tip;
import si.fri.rso.recepti.repositories.ReceptiRepository;
import si.fri.rso.recepti.repositories.SestavineRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptiService {

    @Autowired
    private ReceptiRepository receptiRepository;

    @Autowired
    private SestavineRepository sestavineRepository;

    /**
     * Get all Recepti
     *
     * @param tip Tip of recept
     * @return List of all recepts
     */
    public List<Recept> getRecepti(Tip tip) {
        if (tip == null) {
            return receptiRepository.findAll();
        } else {
            return receptiRepository.findByTip(tip);
        }
    }

    /**
     * Get Recept By Id
     *
     * @param receptId Id recepta
     * @return Recept by Id
     */
    public Recept getReceptById(Integer receptId) {
        return receptiRepository.findById(receptId).orElse(null);
    }

    /**
     * Add new Recept
     *
     * @param recept Recept to save
     * @return Saved recept
     */
    public Recept addRecept(Recept recept) {

        for (Sestavina sestavina : recept.getSestavine()) {
            sestavina.setCreated(LocalDate.now());
            sestavina.setRecept(recept);
        }
        recept.setCreated(LocalDate.now());
        return receptiRepository.save(recept);
    }

    /**
     * Delete recept
     *
     * @param receptId Id of Recept
     */
    public Boolean deleteRecept(Integer receptId) {
        receptiRepository.deleteById(receptId);
        return true;
    }

    /**
     * Update recept
     *
     * @param recept Recept that will be updated
     * @param receptId Recept If
     * @return Updated Recept
     */
    public Recept updateRecept(Recept recept, Integer receptId) {
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

    /**
     * Get Sestavine By Recept
     *
     * @param receptId Id of Recept
     * @return List of all sestavinas
     */
    public List<Sestavina> getSestavineByRecept(Integer receptId) {
        Optional<Recept> recept = receptiRepository.findById(receptId);
        return recept.map(value -> sestavineRepository.getByRecept(value)).orElse(null);
    }

    /**
     * Add new Sestavina on Recept
     *
     * @param receptId Id of Recept
     * @param sestavina Sestavina that will be added
     * @return Saved Sestavina
     */
    public Sestavina addSestavina(Integer receptId, Sestavina sestavina) {
        Optional<Recept> recept = receptiRepository.findById(receptId);
        if (recept.isPresent()) {
            sestavina.setRecept(recept.get());
            sestavina.setCreated(LocalDate.now());
            return sestavineRepository.save(sestavina);
        } else {
            return null;
        }
    }

    /**
     * Delete Sestavina
     *
     * @param sestavinaId If of Sestavina
     */
    public Boolean deleteSestavina(Integer sestavinaId) {
        sestavineRepository.deleteById(sestavinaId);
        return true;
    }

    /**
     * Update Sestavina
     *
     * @param sestavina Sestavina that will be updated
     * @param sestavinaId Id of Sestavina
     * @return Updated Sestavina
     */
    public Sestavina updateSestavina(Sestavina sestavina, Integer sestavinaId) {

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

}
