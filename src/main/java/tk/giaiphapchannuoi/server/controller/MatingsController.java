package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.ListMatingsMatingDetailsDTO;
import tk.giaiphapchannuoi.server.DTO.MatingsMatingDetailsDTO;
import tk.giaiphapchannuoi.server.model.*;
import tk.giaiphapchannuoi.server.services.*;

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

    @Autowired
    SpermService spermService;

    @GetMapping(value = "/one/{id}")
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

    @GetMapping(value = "/matingsmatingdetails/list")
    public ListMatingsMatingDetailsDTO findListMatingsMatingDetails(){
        ListMatingsMatingDetailsDTO listMatingsMatingDetailsDTO = new ListMatingsMatingDetailsDTO() ;
        listMatingsMatingDetailsDTO.setMatings(matingsService.findall());
        listMatingsMatingDetailsDTO.setMatingDetails(matingDetailsService.findall());
        return listMatingsMatingDetailsDTO;
    }

    @Transactional
    @PostMapping(value = "/matingsmatingdetails/")
    public ResponseEntity<Object> insertMatingsMatingDetails(@RequestBody MatingsMatingDetailsDTO matingsMatingDetailsDTO){
        //Luu thong tin mating sau khi luu mating tu request
        Matings mating = matingsService.save(matingsMatingDetailsDTO.getMating());
        //Lay danh sach mating detail tu request
        List<MatingDetails> matingDetailsList = matingsMatingDetailsDTO.getMatingDetail();

        for (MatingDetails matingDetail :
                matingDetailsList) {
            if (matingDetail.getId() == null){
                Optional<Sperm> sperm = spermService.findbyid(matingDetail.getSperm().getId());
                if (sperm.isPresent()){
                    Sperm temp = sperm.get();
                    if (temp.getUsed() < temp.getDoses()){
                        temp.setUsed(temp.getUsed() + 1);
                        spermService.update(temp);
                    }else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("1433: so luong con lai khong du");
                    }
                }else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
            }
        }

        matingDetailsService.deleteByMating(mating);

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


    @Transactional
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
