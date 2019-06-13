package tk.giaiphapchannuoi.server.controller;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Minings;
import tk.giaiphapchannuoi.server.services.MiningsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/minings")
public class MiningsController {

    @Autowired
    MiningsService miningsService;

    @PostMapping(value = "/")
    public Minings classification(@RequestBody Minings mining){
        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();
        bayes.setMemoryCapacity(5000);

        List<Minings> miningsList = miningsService.findall();
        for (Minings m :
                miningsList) {
            if (m.getClassification().equals("Loai 1")){
                List<String> list = new ArrayList<>();
                list.add(m.getIndex().toString());
                list.add(m.getOriginWeight().toString());
                list.add(m.getFoot().toString());
                list.add(m.getGential().toString());
                list.add(m.getUdder().toString());
                list.add(m.getAdg().toString());
                bayes.learn("Loai 1", list);
            } else if (m.getClassification().equals("Loai 2")){
                List<String> list = new ArrayList<>();
                list.add(m.getIndex().toString());
                list.add(m.getOriginWeight().toString());
                list.add(m.getFoot().toString());
                list.add(m.getGential().toString());
                list.add(m.getUdder().toString());
                list.add(m.getAdg().toString());
                bayes.learn("Loai 2", list);
            } else if (m.getClassification().equals("Loai 3")){
                List<String> list = new ArrayList<>();
                list.add(m.getIndex().toString());
                list.add(m.getOriginWeight().toString());
                list.add(m.getFoot().toString());
                list.add(m.getGential().toString());
                list.add(m.getUdder().toString());
                list.add(m.getAdg().toString());
                bayes.learn("Loai 3", list);
            } else if (m.getClassification().equals("Loai 4")){
                List<String> list = new ArrayList<>();
                list.add(m.getIndex().toString());
                list.add(m.getOriginWeight().toString());
                list.add(m.getFoot().toString());
                list.add(m.getGential().toString());
                list.add(m.getUdder().toString());
                list.add(m.getAdg().toString());
                bayes.learn("Loai 4", list);
            }
        }

        List<String> list = new ArrayList<>();
        list.add(String.valueOf(mining.getIndex()));
        list.add(String.valueOf(mining.getOriginWeight()));
        list.add(String.valueOf(mining.getFoot()));
        list.add(String.valueOf(mining.getGential()));
        list.add(String.valueOf(mining.getUdder()));
        list.add(String.valueOf(mining.getAdg()));

        String catogory = bayes.classify(list).getCategory();

        mining.setClassification(catogory);
        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                list);

        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
        return mining;
    }
}
