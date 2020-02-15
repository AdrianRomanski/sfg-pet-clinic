package adrianromanski.sfgpetclinic.repositories;

import adrianromanski.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
