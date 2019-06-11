package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.ScheduleDTO;
import tk.giaiphapchannuoi.server.model.Schedule;
import tk.giaiphapchannuoi.server.services.BreedingsService;
import tk.giaiphapchannuoi.server.services.ScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    @Autowired
    BreedingsService breedingsService;

    @Autowired
    ScheduleService scheduleService;

    @GetMapping(value = "/list")
    public ScheduleDTO findall(){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setBreedings(breedingsService.findall());
        return scheduleDTO;
    }

    @GetMapping(value = "/{id}")
    public Optional<Schedule> findById(@PathVariable Integer id){
        return scheduleService.findbyid(id);
    }

    @GetMapping(value = "/listschedule")
    public List<Schedule> findallschedule(){
        return scheduleService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Schedule schedule){
        Schedule temp = scheduleService.save(schedule);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Schedule schedule){
        Schedule temp = scheduleService.update(schedule);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Schedule schedule){
        return scheduleService.delete(schedule);
    }

}
