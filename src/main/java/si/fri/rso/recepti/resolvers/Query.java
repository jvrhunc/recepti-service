package si.fri.rso.recepti.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import si.fri.rso.recepti.models.Recept;
import si.fri.rso.recepti.repositories.ReceptiRepository;
import si.fri.rso.recepti.repositories.SestavineRepository;

public class Query implements GraphQLQueryResolver {

    private ReceptiRepository receptiRepository;

    private SestavineRepository sestavineRepository;

    public Query(ReceptiRepository receptiRepository, SestavineRepository sestavineRepository) {
        this.receptiRepository = receptiRepository;
        this.sestavineRepository = sestavineRepository;
    }

    public Iterable<Recept> findAllRecepts() {
        return receptiRepository.findAll();
    }

    public Recept findReceptById(Integer id) {
        return receptiRepository.findById(id).orElse(null);
    }

    public Iterable<Recept> findReceptByUser(Integer user) {
        return receptiRepository.findByUporabnikId(user);
    }

}
