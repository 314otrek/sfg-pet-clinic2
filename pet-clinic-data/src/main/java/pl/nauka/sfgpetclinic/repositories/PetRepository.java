package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
