package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.PigTransfer;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.PigTransferRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PigTransferService {

    @Autowired
    PigTransferRepository pigTransferRepository;

    @Autowired
    PigsRepository pigsRepository;

    public List<PigTransfer> findall(){
        return pigTransferRepository.findAllByDelFlag(false);
    }

    public Optional<PigTransfer> findbyid(Integer id){
        return pigTransferRepository.findByIdAndDelFlag(id,false);
    }

    public PigTransfer findbypigandstatuswaiting(Integer pigId){
        Pigs pig = pigsRepository.findByIdAndDelFlag(pigId,false).get();
        List<PigTransfer> pigTransferList = pigTransferRepository.findByPigAndStatusAndDelFlag(pig, "waiting",false);
        PigTransfer temp =  new PigTransfer();
        for (PigTransfer p :
                pigTransferList) {
            temp.setId(p.getId());
            temp.setFromFarm(p.getFromFarm());
            temp.setToFarm(p.getToFarm());
            temp.setPig(p.getPig());
            temp.setStatus(p.getStatus());
            temp.setDate(p.getDate());
            temp.setDelFlag(p.getDelFlag());
            temp.setCreatedAt(p.getCreatedAt());
            temp.setUpdatedAt(p.getUpdatedAt());
        }
        return temp;
    }

    public List<PigTransfer> findbypigandstatusfinish(Integer pigId){
        Pigs pig = pigsRepository.findByIdAndDelFlag(pigId,false).get();
        return pigTransferRepository.findByPigAndStatusAndDelFlag(pig, "finish",false);
    }

    public List<PigTransfer> findallbystatuswaiting(Integer pigId){
        Pigs pig = pigsRepository.findByIdAndDelFlag(pigId,false).get();
        return pigTransferRepository.findByStatusAndDelFlag("waiting",false);
    }

    public List<PigTransfer> findbypig(Integer pigId){
        Pigs pig = pigsRepository.findByIdAndDelFlag(pigId,false).get();
        return pigTransferRepository.findByPigAndDelFlag(pig, false);
    }

    public PigTransfer save(PigTransfer pigTransfer){
        pigTransfer.setDelFlag(false);
        return pigTransferRepository.save(pigTransfer);
    }

    public PigTransfer update(PigTransfer pigTransfer){
        return pigTransferRepository.save(pigTransfer);
    }

    public Boolean delete(PigTransfer pigTransfer){
        pigTransfer.setDelFlag(true);
        if(pigTransferRepository.save(pigTransfer) != null){
            return true;
        }
        return false;
    }
}
