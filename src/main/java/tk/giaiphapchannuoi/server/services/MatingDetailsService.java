package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.repository.MatingDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatingDetailsService {

    @Autowired
    MatingDetailsRepository matingDetailsRepository;

    public List<MatingDetails> findall(){
        return matingDetailsRepository.findAllByDelFlag(false);
    }

    public Optional<MatingDetails> findbyid(Integer id){
        return matingDetailsRepository.findByIdAndDelFlag(id,false);
    }

    public MatingDetails save(MatingDetails matingDetail){
        matingDetail.setDelFlag(false);
        return matingDetailsRepository.save(matingDetail);
    }

    public MatingDetails update(MatingDetails matingDetail){
        return matingDetailsRepository.save(matingDetail);
    }


    public Boolean delete(MatingDetails matingDetail){
        matingDetail.setDelFlag(true);
        if(matingDetailsRepository.save(matingDetail) != null){
            return true;
        }
        return false;
    }
}
