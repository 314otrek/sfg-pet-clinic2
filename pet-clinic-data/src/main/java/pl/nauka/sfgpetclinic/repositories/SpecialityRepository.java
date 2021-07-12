package pl.nauka.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Speciality;

public interface SpecialityRepository  extends CrudRepository<Speciality,Long> {
}
