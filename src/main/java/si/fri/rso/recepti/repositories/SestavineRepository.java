package si.fri.rso.recepti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import si.fri.rso.recepti.models.entities.Recept;
import si.fri.rso.recepti.models.entities.Sestavina;

import java.util.List;

public interface SestavineRepository extends JpaRepository<Sestavina, Integer> {
    List<Sestavina> getByRecept(Recept recept);
}
