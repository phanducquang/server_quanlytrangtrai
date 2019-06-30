package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.repository.MatingDetailsRepository;
import tk.giaiphapchannuoi.server.repository.MatingsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatingDetailsService {

    @Autowired
    MatingDetailsRepository matingDetailsRepository;

    @Autowired
    MatingsRepository matingsRepository;

    @Autowired
    UsersService usersService;

    public List<MatingDetails> findall(){
        Integer farmId = usersService.getFarmId();
        List<MatingDetails> temp = matingDetailsRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<MatingDetails> matingDetailsList = new ArrayList<>();
        for (MatingDetails md :
                temp) {
            if (md.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                matingDetailsList.add(md);
            }
        }
        return matingDetailsList;
    }

    public Optional<MatingDetails> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<MatingDetails> matingDetail = matingDetailsRepository.findByIdAndDelFlag(id,false);
        if (matingDetail.isPresent()){
            if (farmId.equals(0) || matingDetail.get().getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                return matingDetail;
            }
        }
        return Optional.empty();
    }

    public List<MatingDetails> findbymating(Matings mating){
        Integer farmId = usersService.getFarmId();
        List<MatingDetails> matingDetailsList = matingDetailsRepository.findByMatingAndDelFlag(mating,false);
        if (!matingDetailsList.isEmpty()){
            if (farmId.equals(0) || matingDetailsList.get(0).getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                return matingDetailsList;
            }
        }
        return Collections.emptyList();
    }

    @Transactional
    public MatingDetails save(MatingDetails matingDetail){
        matingDetail.setDelFlag(false);
        return matingDetailsRepository.save(matingDetail);
    }

    public MatingDetails update(MatingDetails matingDetail){
        Integer farmId = usersService.getFarmId();
        Optional<Matings> mating = matingsRepository.findByIdAndDelFlag(matingDetail.getMating().getId(),false);
        Integer farmIdFromMatingDetail = mating.map(m -> m.getMother().getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromMatingDetail)){
            return matingDetailsRepository.save(matingDetail);
        }
        return null;
    }


    public Boolean delete(MatingDetails matingDetail){
        matingDetail.setDelFlag(true);
        if(update(matingDetail) != null){
            return true;
        }
        return false;
    }

    public void deleteByMating(Matings mating){
        List<MatingDetails> matingDetailsList = matingDetailsRepository.findByMatingAndDelFlag(mating,false);
        if (!matingDetailsList.isEmpty()){
            matingDetailsRepository.delete(matingDetailsList.get(0));
        }
    }
}
