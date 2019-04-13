package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.IssuesDiseases;
import tk.giaiphapchannuoi.server.repository.IssuesDiseasesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssuesDiseasesService {

    @Autowired
    IssuesDiseasesRepository issuesDiseasesRepository;

    public List<IssuesDiseases> findall(){
        return issuesDiseasesRepository.findAllByDelFlag(false);
    }

    public Optional<IssuesDiseases> findbyid(Integer id){
        return issuesDiseasesRepository.findByIdAndDelFlag(id,false);
    }

    public IssuesDiseases save(IssuesDiseases issuesDisease){
        issuesDisease.setDelFlag(false);
        return issuesDiseasesRepository.save(issuesDisease);
    }

    public IssuesDiseases update(IssuesDiseases issuesDisease){
        return issuesDiseasesRepository.save(issuesDisease);
    }


    public Boolean delete(IssuesDiseases issuesDisease){
        issuesDisease.setDelFlag(true);
        if(issuesDiseasesRepository.save(issuesDisease) != null){
            return true;
        }
        return false;
    }
}
