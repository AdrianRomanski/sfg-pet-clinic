package adrianromanski.sfgpetclinic.bootstrap;

import adrianromanski.sfgpetclinic.model.Owner;
import adrianromanski.sfgpetclinic.model.Pet;
import adrianromanski.sfgpetclinic.model.PetType;
import adrianromanski.sfgpetclinic.model.Vet;
import adrianromanski.sfgpetclinic.services.OwnerService;
import adrianromanski.sfgpetclinic.services.PetTypeService;
import adrianromanski.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
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


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shrek");
        owner2.setLastName("Swamp");
        owner2.setAddress("1 WoodStreet");
        owner2.setCity("Ohio");
        owner2.setTelephone("321321321");

        Pet shrekCat = new Pet();
        shrekCat.setName("Catty");
        shrekCat.setOwner(owner2);
        shrekCat.setBirthDate(LocalDate.now());
        shrekCat.setPetType(savedCatPetType);
        owner2.getPets().add(shrekCat);


        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Trinity");
        vet2.setLastName("Steward");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");



    }
}
