package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.CustomerTypes;
import tk.giaiphapchannuoi.server.repository.CustomerTypesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerTypesService {

    @Autowired
    CustomerTypesRepository customerTypesRepository;

    public List<CustomerTypes> findall(){
        return customerTypesRepository.findAllByDelFlag(false);
    }

    public Optional<CustomerTypes> findbyid(Integer id){
        return customerTypesRepository.findByIdAndDelFlag(id,false);
    }

    public CustomerTypes save(CustomerTypes customerTypes){
        return customerTypesRepository.save(customerTypes);
    }

    public Boolean delete(CustomerTypes customerTypes){
        customerTypes.setDelFlag(true);
        if(customerTypesRepository.save(customerTypes) != null){
            return true;
        }
        return false;
    }
}
