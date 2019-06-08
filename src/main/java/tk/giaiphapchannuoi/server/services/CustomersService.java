package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Customers;
import tk.giaiphapchannuoi.server.repository.CustomersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;
    
    @Autowired
    UsersService usersService;

    public List<Customers> findall(){
        Integer farmId = usersService.getFarmId();
        List<Customers> temp = customersRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Customers> customersList = new ArrayList<>();
        for (Customers c :
                temp) {
            if (c.getFarmId().equals(farmId)){
                customersList.add(c);
            }
        }
        return customersList;
    }

    public Optional<Customers> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Customers> customer = customersRepository.findByIdAndDelFlag(id,false);
        if (customer.isPresent()){
            if (farmId.equals(0) || customer.get().getFarmId().equals(farmId)){
                return customer;
            }
        }
        return Optional.empty();
    }

    public Customers save(Customers customers){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || customers.getFarmId().equals(farmId)){
            customers.setDelFlag(false);
            return customersRepository.save(customers);
        }
        return null;
    }

    public Customers update(Customers customers){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || customers.getFarmId().equals(farmId)){
            return customersRepository.save(customers);
        }
        return null;
    }


    public Boolean delete(Customers customers){
        customers.setDelFlag(true);
        if(update(customers) != null){
            return true;
        }
        return false;
    }
}
