package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Owner;

public interface OwnerRepository  extends CrudRepository<Owner,Long> {
}
