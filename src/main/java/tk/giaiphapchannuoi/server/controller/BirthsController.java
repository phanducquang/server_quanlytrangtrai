package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.model.Births;
import tk.giaiphapchannuoi.server.services.BirthsService;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping(value = "/births")
public class BirthsController {

    @Autowired
    BirthsService birthsService;

    @GetMapping(value = "/{id}")
    public Optional<Births> findbirth(@PathVariable Integer id){
        return birthsService.findbyid(id);
    }
}
