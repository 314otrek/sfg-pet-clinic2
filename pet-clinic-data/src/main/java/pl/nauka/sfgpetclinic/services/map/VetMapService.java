package pl.nauka.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.nauka.sfgpetclinic.model.Speciality;
import pl.nauka.sfgpetclinic.model.Vet;
import pl.nauka.sfgpetclinic.services.SpecialityService;
import pl.nauka.sfgpetclinic.services.VetService;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetMapService extends  AbstractMapService<Vet,Long> implements VetService {

   private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }
}
