package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Customers;
import tk.giaiphapchannuoi.server.repository.CustomersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    public List<Customers> findall(){
        return customersRepository.findAllByDelFlag(false);
    }

    public Optional<Customers> findbyid(Integer id){
        return customersRepository.findByIdAndDelFlag(id,false);
    }

    public Customers save(Customers customers){
        customers.setDelFlag(false);
        return customersRepository.save(customers);
    }

    public Customers update(Customers customers){
        return customersRepository.save(customers);
    }


    public Boolean delete(Customers customers){
        customers.setDelFlag(true);
        if(customersRepository.save(customers) != null){
            return true;
        }
        return false;
    }
}
