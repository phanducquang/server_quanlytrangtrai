package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Issues;
import tk.giaiphapchannuoi.server.repository.IssuesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssuesService {

    @Autowired
    IssuesRepository issuesRepository;

    public List<Issues> findall(){
        return issuesRepository.findAllByDelFlag(false);
    }

    public Optional<Issues> findbyid(Integer id){
        return issuesRepository.findByIdAndDelFlag(id,false);
    }

    public Issues save(Issues issues){
        issues.setDelFlag(false);
        return issuesRepository.save(issues);
    }

    public Issues update(Issues issues){
        return issuesRepository.save(issues);
    }


    public Boolean delete(Issues issues){
        issues.setDelFlag(true);
        if(issuesRepository.save(issues) != null){
            return true;
        }
        return false;
    }
}
