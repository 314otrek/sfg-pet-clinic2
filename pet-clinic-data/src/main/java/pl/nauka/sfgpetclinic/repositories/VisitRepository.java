package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
