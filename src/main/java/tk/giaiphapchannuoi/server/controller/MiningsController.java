package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.MiningResponse;
import tk.giaiphapchannuoi.server.model.ApiResponse;
import tk.giaiphapchannuoi.server.services.MiningsService;

@RestController
@RequestMapping(value = "/api/minings")
public class MiningsController {

    @Autowired
    MiningsService miningsService;

    @GetMapping(value = "/{pigId}")
    public ResponseEntity<Object> classification(@PathVariable Integer pigId){
        MiningResponse temp = miningsService.classification(pigId);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/update/{pigId}/{classification}")
    public ResponseEntity<Object> updateclassification(@PathVariable Integer pigId, @PathVariable String classification){
        ApiResponse temp = miningsService.updateclassification(pigId, classification);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

//    @GetMapping(value = "/autoupdate/")
//    public void autoclassification(){
//        miningsService.autoclassification();
//    }

    @GetMapping(value = "/training/")
    public ResponseEntity<Object> training(){
        if (miningsService.training()){
            ApiResponse apiResponse = new ApiResponse(true,"success");
            return ResponseEntity.ok(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
