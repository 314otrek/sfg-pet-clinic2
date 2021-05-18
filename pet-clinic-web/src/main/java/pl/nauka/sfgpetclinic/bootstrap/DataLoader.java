package pl.nauka.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.nauka.sfgpetclinic.model.Owner;
import pl.nauka.sfgpetclinic.model.PetType;
import pl.nauka.sfgpetclinic.model.Vet;
import pl.nauka.sfgpetclinic.services.OwnerService;
import pl.nauka.sfgpetclinic.services.PetTypeService;
import pl.nauka.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1  =new Owner();
        owner1.setFirstName("Peter");
        owner1.setLastName("Zenulozki");
        ownerService.save(owner1);

        Owner owner2  =new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Gagri");
        ownerService.save(owner2);

        System.out.println("Loaded Owners .....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Kongo");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kasper");
        vet2.setLastName("Pago");
        vetService.save(vet2);

        System.out.println("Loaded Vets ......");


    }
}
