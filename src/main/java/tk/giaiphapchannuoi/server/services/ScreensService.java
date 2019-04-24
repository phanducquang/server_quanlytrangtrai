package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Screens;
import tk.giaiphapchannuoi.server.repository.ScreensRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScreensService {

    @Autowired
    ScreensRepository screensRepository;

    public List<Screens> findall(){
        return screensRepository.findAllByDelFlag(false);
    }

    public Optional<Screens> findbyid(Integer id){
        return screensRepository.findByIdAndDelFlag(id,false);
    }

    public Screens save(Screens screen){
        screen.setDelFlag(false);
        return screensRepository.save(screen);
    }

    public Screens update(Screens screen){
        return screensRepository.save(screen);
    }

    public Boolean delete(Screens screen){
        screen.setDelFlag(true);
        if(screensRepository.save(screen) != null){
            return true;
        }
        return false;
    }
}
