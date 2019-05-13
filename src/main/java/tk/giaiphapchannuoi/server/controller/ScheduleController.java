package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.DTO.ScheduleDTO;
import tk.giaiphapchannuoi.server.services.BreedingsService;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    @Autowired
    BreedingsService breedingsService;

    @GetMapping(value = "/list")
    public ScheduleDTO findall(){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setBreedings(breedingsService.findall());
        return scheduleDTO;
    }
}
