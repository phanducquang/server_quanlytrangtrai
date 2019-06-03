package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.services.PigsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pigs")
public class PigsController {

    @Autowired
    PigsService pigsService;

    @GetMapping(value = "/{id}")
    public Optional<Pigs> findById(@PathVariable Integer id){
        return pigsService.findbyid(id);
    }

    @GetMapping(value = "/issusehealthstatus/")
    public List<Pigs> findByHealthStatus(){
        return pigsService.findbyhealthstatus();
    }

    @GetMapping(value = "/list")
    public List<PigsDTO> findAll(){
        return pigsService.findall();
    }

    @SuppressWarnings("Duplicates")
    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Pigs pig){
        Pigs temp = pigsService.save(pig);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        PigsDTO pigsDTO = new PigsDTO(temp.getId(),temp.getPigCode(),temp.getHouse().getId(),temp.getRound().getId(),temp.getBirthId(),temp.getBreed().getId(),temp.getGender(),temp.getBirthday(),temp.getBorn_weight(),temp.getBornStatus(),temp.getOriginId(),temp.getOriginFather(), temp.getOriginMother(),temp.getOriginWeight(),temp.getReceiveWeight(), temp.getHealthPoint(),temp.getFoot().getId(),temp.getFunctionUdder(),temp.getTotalUdder(),temp.getGentialType().getId(), temp.getDescription(),temp.getFcr(),temp.getAdg(),temp.getBf(),temp.getFilet(),temp.getLongBack(),temp.getLongBody(),temp.getIndex(),temp.getParities(),temp.getImages(),temp.getHealthStatus().getId(),temp.getBreedingType(),temp.getBreedStatus(),temp.getPregnancyStatus().getId(),temp.getPoint_review(),temp.getStatus().getId(),temp.getPriceCode().getId(),temp.getOverviewStatus(),temp.getDelFlag());
//        pigsDTO.setId(temp.getId());
//        pigsDTO.setPigCode(temp.getPigCode());
//        pigsDTO.set
        return ResponseEntity.ok(pigsDTO);
    }

    @Transactional
    @SuppressWarnings("Duplicates")
    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Pigs pig){
        Pigs temp = pigsService.update(pig);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        PigsDTO pigsDTO = new PigsDTO(temp.getId(),temp.getPigCode(),temp.getHouse().getId(),temp.getRound().getId(),temp.getBirthId(),temp.getBreed().getId(),temp.getGender(),temp.getBirthday(),temp.getBorn_weight(),temp.getBornStatus(),temp.getOriginId(),temp.getOriginFather(), temp.getOriginMother(),temp.getOriginWeight(),temp.getReceiveWeight(), temp.getHealthPoint(),temp.getFoot().getId(),temp.getFunctionUdder(),temp.getTotalUdder(),temp.getGentialType().getId(), temp.getDescription(),temp.getFcr(),temp.getAdg(),temp.getBf(),temp.getFilet(),temp.getLongBack(),temp.getLongBody(),temp.getIndex(),temp.getParities(),temp.getImages(),temp.getHealthStatus().getId(),temp.getBreedingType(),temp.getBreedStatus(),temp.getPregnancyStatus().getId(),temp.getPoint_review(),temp.getStatus().getId(),temp.getPriceCode().getId(),temp.getOverviewStatus(),temp.getDelFlag());
        return ResponseEntity.ok(pigsDTO);
    }

    @Transactional
    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Pigs pig){
        return pigsService.delete(pig);
    }
}
