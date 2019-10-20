package adrianromanski.sfgpetclinic.services;

import adrianromanski.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
