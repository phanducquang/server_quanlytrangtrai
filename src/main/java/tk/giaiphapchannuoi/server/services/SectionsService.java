package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Sections;
import tk.giaiphapchannuoi.server.repository.SectionsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionsService {

    @Autowired
    SectionsRepository sectionsRepository;

    @Autowired
    UsersService usersService;

    public List<Sections> findall(){
        Integer farmId = usersService.getFarmId();
        List<Sections> temp = sectionsRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Sections> sectionsList = new ArrayList<>();
        for (Sections s :
                temp) {
            if (s.getFarm().getId().equals(farmId)){
                sectionsList.add(s);
            }
        }
        return sectionsList;
    }

    public Optional<Sections> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Sections> section = sectionsRepository.findByIdAndDelFlag(id,false);
        if (section.isPresent()){
            if (farmId.equals(0) || section.get().getFarm().getId().equals(farmId)){
                return section;
            }
        }
        return Optional.empty();
    }

    public Sections save(Sections section){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || section.getFarm().getId().equals(farmId)){
            section.setDelFlag(false);
            return sectionsRepository.save(section);
        }
        return null;
    }

    public Sections update(Sections section){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || section.getFarm().getId().equals(farmId)){
            return sectionsRepository.save(section);
        }
        return null;
    }


    public Boolean delete(Sections section){
        section.setDelFlag(true);
        if(update(section) != null){
            return true;
        }
        return false;
    }
}
