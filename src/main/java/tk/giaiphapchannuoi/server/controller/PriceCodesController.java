package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.PriceCodes;
import tk.giaiphapchannuoi.server.services.PriceCodesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pricecodes")
public class PriceCodesController {

    @Autowired
    PriceCodesService priceCodesService;

    @GetMapping(value = "/{id}")
    public Optional<PriceCodes> findById(@PathVariable Integer id){
        return priceCodesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<PriceCodes> findAll(){
        return priceCodesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody PriceCodes priceCode){
        PriceCodes temp = priceCodesService.save(priceCode);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody PriceCodes priceCode){
        PriceCodes temp = priceCodesService.update(priceCode);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody PriceCodes priceCode){
        return priceCodesService.delete(priceCode);
    }
}
