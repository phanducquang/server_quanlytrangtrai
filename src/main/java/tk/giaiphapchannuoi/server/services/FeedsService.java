package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.repository.FeedsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeedsService {

    @Autowired
    FeedsRepository feedsRepository;

    public List<Feeds> findall(){
        return feedsRepository.findAllByDelFlag(false);
    }

    public Optional<Feeds> findbyid(Integer id){
        return feedsRepository.findByIdAndDelFlag(id,false);
    }

    public Feeds save(Feeds feed){
        feed.setDelFlag(false);
        return feedsRepository.save(feed);
    }

    public Feeds update(Feeds feed){
        return feedsRepository.save(feed);
    }


    public Boolean delete(Feeds feed){
        feed.setDelFlag(true);
        if(feedsRepository.save(feed) != null){
            return true;
        }
        return false;
    }
}
