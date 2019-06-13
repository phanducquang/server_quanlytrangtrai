package tk.giaiphapchannuoi.server.controller;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.MiningResponse;
import tk.giaiphapchannuoi.server.model.Minings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.services.MiningsService;

import java.util.ArrayList;
import java.util.List;

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
}
