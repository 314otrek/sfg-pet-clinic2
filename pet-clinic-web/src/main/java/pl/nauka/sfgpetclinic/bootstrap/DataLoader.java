package pl.nauka.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.nauka.sfgpetclinic.model.Owner;
import pl.nauka.sfgpetclinic.model.Vet;
import pl.nauka.sfgpetclinic.services.OwnerService;
import pl.nauka.sfgpetclinic.services.VetService;

@Component()
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }
    @Override
    public void run(String... args) throws Exception {

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
