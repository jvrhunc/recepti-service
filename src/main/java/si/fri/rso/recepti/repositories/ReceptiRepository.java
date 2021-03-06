package si.fri.rso.recepti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import si.fri.rso.recepti.models.entities.Recept;
import si.fri.rso.recepti.models.enums.Tip;

import java.util.List;

public interface ReceptiRepository extends JpaRepository<Recept, Integer> {
    List<Recept> findByTip(Tip tip);
    List<Recept> findByUporabnikId(Integer uporabnikId);
}
