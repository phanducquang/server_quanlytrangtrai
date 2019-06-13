package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Minings;
import tk.giaiphapchannuoi.server.repository.MiningsRepository;

import java.util.List;

@Service
@Transactional
public class MiningsService {

    @Autowired
    MiningsRepository miningsRepository;

    public List<Minings> findall(){
        return miningsRepository.findAll();
    }

    public Minings save(Minings medicineType){
        return miningsRepository.save(medicineType);
    }



    public Integer convertIndex(Float index){
        if (index > 105) {
            return 1;
        } else if (index > 95 && index <= 105) {
            return 2;
        } else if (index > 85 && index <= 95) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertWeight(Float weight) {
        if (weight > 150) {
            return 1;
        } else if (weight > 110 && weight <= 150) {
            return 2;
        } else if (weight > 90 && weight <= 110) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertMaleUdder(Float mUdder) {
        if (mUdder >= 16) {
            return 1;
        } else if (mUdder == 15) {
            return 2;
        } else if (mUdder == 14) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertFemaleUdder(Float fUdder) {
        if (fUdder >= 16) {
            return 1;
        } else if (fUdder >= 14 && fUdder <= 15) {
            return 2;
        } else if (fUdder >= 12 && fUdder <= 13) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertGential(Float gential) {
        if (gential == 4 || gential == 5) {
            return 1;
        } else if (gential == 3) {
            return 2;
        } else if (gential == 2) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertFoot(Float foot) {
        if (foot == 4 || foot == 5) {
            return 1;
        } else if (foot == 3) {
            return 2;
        } else if (foot == 2) {
            return 3;
        } else {
            return 4;
        }
    }

    public Integer convertAdg(Float adg) {
        if (adg > 900) {
            return 1;
        } else if (adg > 800 && adg <= 900) {
            return 2;
        } else if (adg >= 700 && adg <= 800) {
            return 3;
        } else {
            return 4;
        }
    }


}
