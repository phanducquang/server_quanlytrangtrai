package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.MatingsMatingDetailsDTO;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.services.MatingDetailsService;
import tk.giaiphapchannuoi.server.services.MatingsService;
import tk.giaiphapchannuoi.server.services.PigsService;
import tk.giaiphapchannuoi.server.services.StatusService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/matings")
public class MatingsController {

    @Autowired
    MatingsService matingsService;

    @Autowired
    MatingDetailsService matingDetailsService;

    @Autowired
    PigsService pigsService;

    @Autowired
    StatusService statusService;

    @GetMapping(value = "/{id}")
    public Optional<Matings> findById(@PathVariable Integer id){
        return matingsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Matings> findAll(){
        return matingsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Matings mating){
        Matings temp = matingsService.save(mating);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @Transactional
    @PostMapping(value = "/matingsmatingdetails/")
    public ResponseEntity<Object> insert(@RequestBody MatingsMatingDetailsDTO matingsMatingDetailsDTO){
        //Luu thong tin mating sau khi luu mating tu request
        Matings mating = matingsService.save(matingsMatingDetailsDTO.getMating());
        //Cap nhat status heo
        Pigs pigs = pigsService.findbyid(mating.getMother().getId()).get();
        if (mating.getStatus().equals("processing")){
            Status status = statusService.findbycode(11).get();
            pigs.setStatus(status);
            pigsService.update(pigs);
        }else if(mating.getStatus().equals("finish")){
            Status status = statusService.findbycode(2).get();
            pigs.setStatus(status);
            pigsService.update(pigs);
        }
        //Lay danh sach mating detail tu request
        List<MatingDetails> matingDetailsList = matingsMatingDetailsDTO.getMatingDetail();
        //Tao danh sach mating detail de luu thong tin mating detail sau khi luu vao db
        List<MatingDetails> matingDetails = new ArrayList<MatingDetails>();
        for (MatingDetails matingDetail :
                matingDetailsList) {
//            if (matingDetail.getMating()==null){
                matingDetail.setMating(mating);
//            }
            matingDetails.add(matingDetailsService.save(matingDetail));
        }
        MatingsMatingDetailsDTO temp = new MatingsMatingDetailsDTO();
        temp.setMating(mating);
        temp.setMatingDetail(matingDetails);
        if(temp.getMating() == null || temp.getMatingDetail() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }


    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Matings mating){
        Matings temp = matingsService.update(mating);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Matings mating){
        return matingsService.delete(mating);
    }
}
