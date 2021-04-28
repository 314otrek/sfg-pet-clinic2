package pl.nauka.sfgpetclinic.services;

import pl.nauka.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findall();
}
