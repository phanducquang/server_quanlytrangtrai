package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.DTO.PigInfoExtendDTO;
import tk.giaiphapchannuoi.server.services.BreedingsService;
import tk.giaiphapchannuoi.server.services.MatingsService;
import tk.giaiphapchannuoi.server.services.SpermService;

@RestController
@RequestMapping(value = "/api/piginfoextend")
public class PigInfoExtendController {

    @Autowired
    BreedingsService breedingsService;

    @Autowired
    MatingsService matingsService;

    @Autowired
    SpermService spermService;

    @GetMapping(value = "/one/{pigId}")
    public PigInfoExtendDTO findByPig(@PathVariable Integer pigId){
        PigInfoExtendDTO pigInfoExtendDTO = new PigInfoExtendDTO();
        pigInfoExtendDTO.setBreedings(breedingsService.findallbypig(pigId));
        pigInfoExtendDTO.setMatings(matingsService.findbypig(pigId));
        pigInfoExtendDTO.setSperms(spermService.findbypig(pigId));
        return pigInfoExtendDTO;
    }

}
