package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.TiLeDiseasesDTO;
import tk.giaiphapchannuoi.server.model.*;
import tk.giaiphapchannuoi.server.repository.IssuesDiseasesRepository;
import tk.giaiphapchannuoi.server.repository.IssuesPigsRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class IssuesPigsService {

    @Autowired
    IssuesPigsRepository issuesPigsRepository;

    @Autowired
    IssuesDiseasesRepository issuesDiseasesRepository;

    @Autowired
    PigsRepository pigsRepository;

    public List<IssuesPigs> findall(){
        return issuesPigsRepository.findAllByDelFlag(false);
    }

    public List<IssuesPigs> findcurrentissues(Integer idfarm, Integer idsection){
        if (idfarm == 0){
            return issuesPigsRepository.findByStatusAndDelFlag("mới phát hiện",false);
        }
        List<IssuesPigs> temp = issuesPigsRepository.findByStatusAndDelFlag("mới phát hiện",false);
        List<IssuesPigs> issuesPigsList = new ArrayList<>();
        for (IssuesPigs ip :
                temp) {
            if (ip.getPig().getHouse().getSection().getId().equals(idsection) && ip.getPig().getHouse().getSection().getFarm().getId().equals(idfarm)){
                issuesPigsList.add(ip);
            }
        }
        return issuesPigsList;
    }

    public List<TiLeDiseasesDTO> forecastdiseases(Integer idfarm, Integer idsection){
        //Lay thong tin van de moi phat hien
        List<IssuesPigs> issuesPigsList = issuesPigsRepository.findByStatusAndDelFlag("mới phát hiện",false);
        List<Issues> issuesList = new ArrayList<>();
        for (IssuesPigs ip :
                issuesPigsList) {
            if (ip.getPig().getHouse().getSection().getId().equals(idsection) && ip.getPig().getHouse().getSection().getFarm().getId().equals(idfarm)){
                issuesList.add(ip.getIssue());
            }
        }

        //Lay thong tin "van de - benh" dua vao thong tin van de da lay tu truoc
        List<IssuesDiseases> issuesDiseasesList = new ArrayList<>();
        for (Issues i :
                issuesList) {
            issuesDiseasesList.addAll(issuesDiseasesRepository.findByIssueAndDelFlag(i,false));
        }

        //Lay thong tin benh
        List<Diseases> diseasesList = new ArrayList<>();
        for (IssuesDiseases id :
                issuesDiseasesList) {
            diseasesList.add(id.getDisease());
        }
        //Loc lay danh sach Diseases khong trung nhau
        List<Diseases> filterDiseases = new ArrayList<>();
        //Lay phan tu dau tien
        if (!diseasesList.isEmpty()){
            filterDiseases.add(diseasesList.get(0));
        }
        //Duyet vong lap thu nhat
        for (int i = 1; i < diseasesList.size(); i++){
            //Duy vong lap thu 2 de tim xem tu i tro ve truoc co trung khong, neu trung break
            for (int j = 0; j < i; j++) {
                if (diseasesList.get(i).equals(diseasesList.get(j))) {
                    break;
                }
                //Neu khong trung thi kiem tra lai lan cuoi xem vi tri j da la gia tri ke truoc i hay chua.
                //Neu thoa thi them vao list
                if (j+1 == i){
                    filterDiseases.add(diseasesList.get(i));
                }
            }
        }
        //Xac dinh tan xuat xuat hien cua benh benh nao nhieu nhat thi kha nang xay ra cao nhat
        List<TiLeDiseasesDTO> tiLeDiseasesDTOList = new ArrayList<>();
        //Duyet vong lap o danh sach benh khong trung lap
        for (int i = 0; i < filterDiseases.size(); i++) {
            TiLeDiseasesDTO temp = new TiLeDiseasesDTO();
            temp.setDisease(filterDiseases.get(i));
            temp.setTiLe(0f);
            //Duyet vong lap o danh sach lay duoc
            for (int j = 0; j < diseasesList.size(); j++) {
                //Neu trung thi cong 1 vao tan xuat
                if (filterDiseases.get(i).equals(diseasesList.get(j))){
                    temp.setTiLe(temp.getTiLe() +1);
                }
            }
            temp.setTiLe(temp.getTiLe()/(float)diseasesList.size());
            tiLeDiseasesDTOList.add(temp);
        }

        tiLeDiseasesDTOList.sort((TiLeDiseasesDTO t1,TiLeDiseasesDTO t2) -> t2.getTiLe().compareTo(t1.getTiLe()));
        return tiLeDiseasesDTOList;
    }

    public Optional<IssuesPigs> findbyid(Integer id){
        return issuesPigsRepository.findByIdAndDelFlag(id,false);
    }

    @Transactional
    public IssuesPigs save(IssuesPigs issuesPig){
        issuesPig.setDelFlag(false);
        issuesPig.setStatus("mới phát hiện");
        Pigs pig = pigsRepository.findByIdAndDelFlag(issuesPig.getPig().getId(), false).get();
        HealthStatus healthStatus = pig.getHealthStatus();
        if(healthStatus.getId() == 1 || healthStatus.getId() == 0){
            healthStatus.setId(2);
            pig.setHealthStatus(healthStatus);
            pigsRepository.save(pig);
        }
        return issuesPigsRepository.save(issuesPig);
    }

    public IssuesPigs update(IssuesPigs issuesPig){
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
