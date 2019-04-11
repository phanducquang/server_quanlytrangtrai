package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.PriceCodes;
import tk.giaiphapchannuoi.server.repository.PriceCodesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PriceCodesService {

    @Autowired
    PriceCodesRepository priceCodesRepository;

    public List<PriceCodes> findall(){
        return priceCodesRepository.findAllByDelFlag(false);
    }

    public Optional<PriceCodes> findbyid(Integer id){
        return priceCodesRepository.findByIdAndDelFlag(id,false);
    }

    public PriceCodes save(PriceCodes priceCode){
        return priceCodesRepository.save(priceCode);
    }

    public Boolean delete(PriceCodes priceCode){
        priceCode.setDelFlag(true);
        if(priceCodesRepository.save(priceCode) != null){
            return true;
        }
        return false;
    }
}
