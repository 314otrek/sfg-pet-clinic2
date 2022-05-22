package pl.nauka.sfgpetclinic.services.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.nauka.sfgpetclinic.model.Owner;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long idd = 1L;
    String lastName = "Smith";

    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(idd).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        Assertions.assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);
        Assertions.assertEquals(idd,owner.getId());
    }

    @Test
    void save() {
        Long id2 = 2L;
        Owner ow1 = Owner.builder().id(id2).firstName("Tomas").build();
        ownerMapService.save(ow1);
        Assertions.assertEquals(2,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(idd));
        Assertions.assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(idd);

        Assertions.assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
       Owner owner =  ownerMapService.findByLastName("Smith");
       Assertions.assertEquals(lastName,owner.getLastName());
    }
}