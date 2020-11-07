package si.fri.rso.recepti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import si.fri.rso.recepti.models.Sestavina;

public interface SestavineRepository extends JpaRepository<Sestavina, Integer> {

}
