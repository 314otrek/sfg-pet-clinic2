package pl.nauka.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.nauka.sfgpetclinic.model.*;
import pl.nauka.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {

        int count  =petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        Owner owner1  =new Owner();
        owner1.setFirstName("Peter");
        owner1.setLastName("Zenulozki");
        owner1.setAddress("Antoniewicza");
        owner1.setCity("Ski");
        owner1.setTelephone("1123151251");

        Pet mikesPEt = new Pet();
        mikesPEt.setPetType(savedDogPetType);
        mikesPEt.setLocalDate(LocalDate.now());
        mikesPEt.setOwner(owner1);
        mikesPEt.setName("Rosco");
        owner1.getPets().add(mikesPEt);

        ownerService.save(owner1);

        Owner owner2  =new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Gagri");
        owner2.setAddress("Reja");
        owner2.setCity("Wawa");
        owner2.setTelephone("959595959");

        Pet Fionascat = new Pet();
        Fionascat.setName("fiona");
        Fionascat.setOwner(owner2);
        Fionascat.setLocalDate(LocalDate.now());
        Fionascat.setPetType(savedCatPetType);
        owner2.getPets().add(Fionascat);

        ownerService.save(owner2);
        Visit catVisit = new Visit();
        catVisit.setPet(Fionascat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);


        System.out.println("Loaded Owners .....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Michael");
        vet1.setLastName("Kongo");
        vet1.getSpecialities().add(saveRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Kasper");
        vet2.setLastName("Pago");
        vet2.getSpecialities().add(saveDentistry);
        vetService.save(vet2);


        System.out.println("Loaded Vets ......");
    }
}
