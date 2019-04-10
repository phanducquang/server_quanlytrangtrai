package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.IssuesPigs;
import tk.giaiphapchannuoi.server.repository.IssuesPigsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssuesPigsService {

    @Autowired
    IssuesPigsRepository issuesPigsRepository;

    public List<IssuesPigs> findall(){
        return issuesPigsRepository.findAllByDelFlag(false);
    }

    public Optional<IssuesPigs> findbyid(Integer id){
        return issuesPigsRepository.findByIdAndDelFlag(id,false);
    }

    public IssuesPigs save(IssuesPigs issuesPig){
        return issuesPigsRepository.save(issuesPig);
    }

    public Boolean delete(IssuesPigs issuesPig){
        issuesPig.setDelFlag(true);
        if(issuesPigsRepository.save(issuesPig) != null){
            return true;
        }
        return false;
    }
}
