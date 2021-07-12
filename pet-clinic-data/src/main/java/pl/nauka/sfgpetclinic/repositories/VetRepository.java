package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
