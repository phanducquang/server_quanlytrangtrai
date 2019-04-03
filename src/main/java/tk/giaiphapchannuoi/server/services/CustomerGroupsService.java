package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.CustomerGroups;
import tk.giaiphapchannuoi.server.repository.CustomerGroupsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerGroupsService {

    @Autowired
    CustomerGroupsRepository customerGroupsRepository;

    public List<CustomerGroups> findall(){
        return customerGroupsRepository.findAllByDelFlag(false);
    }

    public Optional<CustomerGroups> findbyid(Integer id){
        return customerGroupsRepository.findByIdAndDelFlag(id,false);
    }

    public CustomerGroups save(CustomerGroups customerGroups){
        return customerGroupsRepository.save(customerGroups);
    }

    public Boolean delete(CustomerGroups customerGroups){
        customerGroups.setDelFlag(true);
        if(customerGroupsRepository.save(customerGroups) != null){
            return true;
        }
        return false;
    }
}
