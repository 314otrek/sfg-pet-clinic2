package pl.nauka.sfgpetclinic.services;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

}
