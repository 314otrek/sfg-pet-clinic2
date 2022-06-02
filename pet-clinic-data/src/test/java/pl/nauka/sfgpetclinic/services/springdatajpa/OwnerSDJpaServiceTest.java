package pl.nauka.sfgpetclinic.services.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nauka.sfgpetclinic.model.Owner;
import pl.nauka.sfgpetclinic.repositories.OwnerRepository;
import pl.nauka.sfgpetclinic.repositories.PetRepository;
import pl.nauka.sfgpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {


    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
    String LAST_NAME = "Smith";;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        log.info(returnOwner.getLastName());
        Owner owner = service.findByLastName(LAST_NAME);

        Assertions.assertEquals("Smith",owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        Assertions.assertNotNull(owners);
        Assertions.assertEquals(2,owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);
        Assertions.assertEquals(returnOwner,owner);

    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any(Owner.class))).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        Assertions.assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        service.delete(returnOwner);

        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}