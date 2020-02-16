package adrianromanski.sfgpetclinic.services.springdatajpa;

import adrianromanski.sfgpetclinic.model.Speciality;
import adrianromanski.sfgpetclinic.repositories.SpecialityRepository;
import adrianromanski.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Profile("springdatajpa")
public class SpecialitiesSDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitiesSDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
       Set<Speciality> specialities = new HashSet<>();
       specialityRepository.findAll().forEach(specialities::add);
       return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElseThrow(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
