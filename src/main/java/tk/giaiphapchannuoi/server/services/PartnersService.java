package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Partners;
import tk.giaiphapchannuoi.server.repository.PartnersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartnersService {

    @Autowired
    PartnersRepository partnersRepository;

    public List<Partners> findall(){
        return partnersRepository.findAllByDelFlag(false);
    }

    public Optional<Partners> findbyid(Integer id){
        return partnersRepository.findByIdAndDelFlag(id,false);
    }

    public Partners save(Partners partner){
        return partnersRepository.save(partner);
    }

    public Boolean delete(Partners partner){
        partner.setDelFlag(true);
        if(partnersRepository.save(partner) != null){
            return true;
        }
        return false;
    }
}
