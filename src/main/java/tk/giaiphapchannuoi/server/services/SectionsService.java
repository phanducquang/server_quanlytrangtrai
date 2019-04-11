package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Sections;
import tk.giaiphapchannuoi.server.repository.SectionsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionsService {

    @Autowired
    SectionsRepository sectionsRepository;

    public List<Sections> findall(){
        return sectionsRepository.findAllByDelFlag(false);
    }

    public Optional<Sections> findbyid(Integer id){
        return sectionsRepository.findByIdAndDelFlag(id,false);
    }

    public Sections save(Sections section){
        return sectionsRepository.save(section);
    }

    public Boolean delete(Sections section){
        section.setDelFlag(true);
        if(sectionsRepository.save(section) != null){
            return true;
        }
        return false;
    }
}
