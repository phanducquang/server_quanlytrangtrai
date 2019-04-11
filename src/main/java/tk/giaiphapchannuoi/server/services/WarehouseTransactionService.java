package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.WarehouseTransaction;
import tk.giaiphapchannuoi.server.repository.WarehouseTransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarehouseTransactionService {

    @Autowired
    WarehouseTransactionRepository warehouseTransactionRepository;

    public List<WarehouseTransaction> findall(){
        return warehouseTransactionRepository.findAllByDelFlag(false);
    }

    public Optional<WarehouseTransaction> findbyid(Integer id){
        return warehouseTransactionRepository.findByIdAndDelFlag(id,false);
    }

    public WarehouseTransaction save(WarehouseTransaction warehouseTransaction){
        return warehouseTransactionRepository.save(warehouseTransaction);
    }

    public Boolean delete(WarehouseTransaction warehouseTransaction){
        warehouseTransaction.setDelFlag(true);
        if(warehouseTransactionRepository.save(warehouseTransaction) != null){
            return true;
        }
        return false;
    }
}
