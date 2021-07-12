package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
