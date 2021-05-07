package pl.nauka.sfgpetclinic.services;

import org.springframework.data.repository.CrudRepository;
import pl.nauka.sfgpetclinic.model.Pet;

public interface PetService extends CrudRepository<Pet,Long> {

 }
