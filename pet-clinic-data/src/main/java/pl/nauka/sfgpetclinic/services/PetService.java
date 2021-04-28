package pl.nauka.sfgpetclinic.services;

import pl.nauka.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findall();
}
