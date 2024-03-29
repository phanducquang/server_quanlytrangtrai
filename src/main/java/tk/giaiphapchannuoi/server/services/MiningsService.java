package tk.giaiphapchannuoi.server.services;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.MiningResponse;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.model.ApiResponse;
import tk.giaiphapchannuoi.server.model.Minings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.MiningsRepository;
import tk.giaiphapchannuoi.server.repository.PigsDTORepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MiningsService {

    @Autowired
    MiningsRepository miningsRepository;

    @Autowired
    PigsService pigsService;

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    PigsDTORepository pigsDTORepository;

    protected static Classifier<String, String> bayes = new BayesClassifier<String, String>();

    protected static Boolean flag_training = false;

    public List<Minings> findall(){
        return miningsRepository.findAll();
    }

    public Minings save(Minings medicineType){
        return miningsRepository.save(medicineType);
    }

    public Boolean training(){

        bayes.reset();
        bayes.setMemoryCapacity(5000);

        List<PigsDTO> pigsList = pigsDTORepository.findAllByDelFlag(false);
        //Lay thong tin tap train tu database
        //cho thuat toan hoc du lieu tu tap train
        for (PigsDTO p :
                pigsList) {
            if (p.getPigType().equals("Loai 1")){
                List<String> list = new ArrayList<>();
                list.add(p.getIndex().toString());
                list.add(p.getOriginWeight().toString());
                list.add(p.getFootTypeId().toString());
                list.add(p.getGentialTypeId().toString());
                //Thuc hien quy doi de dong bo giua con duc va cai
                if (p.getGender().equals(1)){
                    list.add(convertMaleUdder(p.getFunctionUdder()));
                } else if (p.getGender().equals(2)){
                    list.add(convertFemaleUdder(p.getFunctionUdder()));
                } else {
                    list.add("4");
                }
//                    list.add(p.getFunctionUdder().toString());
                list.add(p.getAdg().toString());
                bayes.learn("Loai 1", list);//bien 1: nhan phan lop; bien 2 collection<String> cac thuoc tinh phan lop
            } else if (p.getPigType().equals("Loai 2")){
                List<String> list = new ArrayList<>();
                list.add(p.getIndex().toString());
                list.add(p.getOriginWeight().toString());
                list.add(p.getFootTypeId().toString());
                list.add(p.getGentialTypeId().toString());
                if (p.getGender().equals(1)){
                    list.add(convertMaleUdder(p.getFunctionUdder()));
                } else if (p.getGender().equals(2)){
                    list.add(convertFemaleUdder(p.getFunctionUdder()));
                } else {
                    list.add("4");
                }
                list.add(p.getAdg().toString());
                bayes.learn("Loai 2", list);
            } else if (p.getPigType().equals("Loai 3")){
                List<String> list = new ArrayList<>();
                list.add(p.getIndex().toString());
                list.add(p.getOriginWeight().toString());
                list.add(p.getFootTypeId().toString());
                list.add(p.getGentialTypeId().toString());
                if (p.getGender().equals(1)){
                    list.add(convertMaleUdder(p.getFunctionUdder()));
                } else if (p.getGender().equals(2)){
                    list.add(convertFemaleUdder(p.getFunctionUdder()));
                } else {
                    list.add("4");
                }
                list.add(p.getAdg().toString());
                bayes.learn("Loai 3", list);
            } else if (p.getPigType().equals("Loai 4")){
                List<String> list = new ArrayList<>();
                list.add(p.getIndex().toString());
                list.add(p.getOriginWeight().toString());
                list.add(p.getFootTypeId().toString());
                list.add(p.getGentialTypeId().toString());
                if (p.getGender().equals(1)){
                    list.add(convertMaleUdder(p.getFunctionUdder()));
                } else if (p.getGender().equals(2)){
                    list.add(convertFemaleUdder(p.getFunctionUdder()));
                } else {
                    list.add("4");
                }
                list.add(p.getAdg().toString());
                bayes.learn("Loai 4", list);
            }
        }
        flag_training = true;
        return true;
    }

    public MiningResponse classification(Integer pigId){
        if (flag_training){
            Optional<Pigs> pig = pigsService.findbyid(pigId);
            if (pig.isPresent()){
                List<String> list = new ArrayList<>();

                list.add(pig.get().getIndex().toString());
                list.add(pig.get().getOriginWeight().toString());
                list.add(pig.get().getFoot().getId().toString());
                list.add(pig.get().getGentialType().getId().toString());
                if (pig.get().getGender().equals(1)){
                    list.add(pig.get().getFunctionUdder().toString());
                } else if (pig.get().getGender().equals(2)){
                    list.add(convertFemaleUdder(pig.get().getFunctionUdder()));
                } else {
                    list.add("4");
                }
                list.add(pig.get().getAdg().toString());

                //Phan lop sau do lay ra category
                String category = bayes.classify(list).getCategory();
                MiningResponse miningResponse =
                        new MiningResponse(pig.get().getIndex(), pig.get().getOriginWeight(),pig.get().getFoot().getName(),pig.get().getGentialType().getName(),pig.get().getFunctionUdder(),pig.get().getAdg(),category);
//                ((BayesClassifier<String, String>) bayes).classifyDetailed(
//                        list);

//                bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
                return miningResponse;
            }
        }else {
            throw new IllegalArgumentException("code 1434: Chua thuc hien training");
        }
        return null;
    }

//    public void autoclassification(){
////        Optional<Pigs> pig = pigsService.findbyid(pigId);
////        if (pig.isPresent()){
//        final Classifier<String, String> bayes = new BayesClassifier<String, String>();
//        //set 5000 learned classifications
//        bayes.setMemoryCapacity(5000);
//
//        List<Pigs> pigsList = pigsRepository.findAllByDelFlag(false);
//        //Lay thong tin tap train tu database
//        List<Minings> miningsList = findall();
//        //cho thuat toan hoc du lieu tu tap train
//        for (Minings m :
//                miningsList) {
//            if (m.getClassification().equals("Loai 1")){
//                List<String> list = new ArrayList<>();
//                list.add(m.getIndex().toString());
//                list.add(m.getOriginWeight().toString());
//                list.add(m.getFoot().toString());
//                list.add(m.getGential().toString());
//                list.add(m.getUdder().toString());
//                list.add(m.getAdg().toString());
//                bayes.learn("Loai 1", list);//bien 1: nhan phan lop; bien 2 collection<String> cac thuoc tinh phan lop
//            } else if (m.getClassification().equals("Loai 2")){
//                List<String> list = new ArrayList<>();
//                list.add(m.getIndex().toString());
//                list.add(m.getOriginWeight().toString());
//                list.add(m.getFoot().toString());
//                list.add(m.getGential().toString());
//                list.add(m.getUdder().toString());
//                list.add(m.getAdg().toString());
//                bayes.learn("Loai 2", list);
//            } else if (m.getClassification().equals("Loai 3")){
//                List<String> list = new ArrayList<>();
//                list.add(m.getIndex().toString());
//                list.add(m.getOriginWeight().toString());
//                list.add(m.getFoot().toString());
//                list.add(m.getGential().toString());
//                list.add(m.getUdder().toString());
//                list.add(m.getAdg().toString());
//                bayes.learn("Loai 3", list);
//            } else if (m.getClassification().equals("Loai 4")){
//                List<String> list = new ArrayList<>();
//                list.add(m.getIndex().toString());
//                list.add(m.getOriginWeight().toString());
//                list.add(m.getFoot().toString());
//                list.add(m.getGential().toString());
//                list.add(m.getUdder().toString());
//                list.add(m.getAdg().toString());
//                bayes.learn("Loai 4", list);
//            }
//        }
//
//        for (Pigs pig :
//                pigsList) {
////            List<String> list = new ArrayList<>();
//            //Chuyen thong tin heo sang diem danh gia chung dua vao tieu chi xep loai
//            Integer index = Integer.parseInt(convertIndex(pig.getIndex()));
//            Integer weight = Integer.parseInt(convertWeight(pig.getOriginWeight()));
//            Integer foot = Integer.parseInt(convertFoot(pig.getFoot().getId()));
//            Integer gential = Integer.parseInt(convertGential(pig.getGentialType().getId()));
//            Integer udder;
//            if (pig.getGender().equals(1)){
//                udder = Integer.parseInt(convertMaleUdder(pig.getFunctionUdder()));
//            } else if (pig.getGender().equals(2)){
//                udder = Integer.parseInt(convertFemaleUdder(pig.getFunctionUdder()));
//            } else {
//                udder = 4;
//            }
//            Integer adg = Integer.parseInt(convertAdg(pig.getAdg()));
//
//            Optional<Minings> mining = miningsRepository.findByIndexAndOriginWeightAndFootAndGentialAndUdderAndAdg(index,weight,foot,gential,udder,adg);
//
//            //Phan lop sau do lay ra category
////            String category = bayes.classify(list).getCategory();
//            pig.setPigType(mining.get().getClassification());
//            pigsRepository.save(pig);
////            ((BayesClassifier<String, String>) bayes).classifyDetailed(
////                    list);
//        }
////            List<String> list = new ArrayList<>();
////            //Chuyen thong tin heo sang diem danh gia chung dua vao tieu chi xep loai
////            list.add(convertIndex(pig.get().getIndex()));
////            list.add(convertWeight(pig.get().getOriginWeight()));
////            list.add(convertFoot(pig.get().getFoot().getId()));
////            list.add(convertGential(pig.get().getGentialType().getId()));
////            if (pig.get().getGender().equals(1)){
////                list.add(convertMaleUdder(pig.get().getFunctionUdder()));
////            } else if (pig.get().getGender().equals(2)){
////                list.add(convertFemaleUdder(pig.get().getFunctionUdder()));
////            } else {
////                list.add("4");
////            }
////            list.add(convertAdg(pig.get().getAdg()));
////
////            //Phan lop sau do lay ra category
////            String category = bayes.classify(list).getCategory();
////            MiningResponse miningResponse =
////                    new MiningResponse(pig.get().getIndex(), pig.get().getOriginWeight(),pig.get().getFoot().getName(),pig.get().getGentialType().getName(),pig.get().getFunctionUdder(),pig.get().getAdg(),category);
////            ((BayesClassifier<String, String>) bayes).classifyDetailed(
////                    list);
//
//        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
////            return miningResponse;
//    }

    public ApiResponse updateclassification(Integer pigId, String classification) {
        Optional<Pigs> pig = pigsService.findbyid(pigId);
        if (pig.isPresent()) {
            Integer index = Integer.parseInt(convertIndex(pig.get().getIndex()));
            Integer weight = Integer.parseInt(convertWeight(pig.get().getOriginWeight()));
            Integer foot = Integer.parseInt(convertFoot(pig.get().getFoot().getId()));
            Integer gential = Integer.parseInt(convertGential(pig.get().getGentialType().getId()));
            Integer udder;
            if (pig.get().getGender().equals(1)){
                udder = Integer.parseInt(convertMaleUdder(pig.get().getFunctionUdder()));
            } else if (pig.get().getGender().equals(2)){
                udder = Integer.parseInt(convertFemaleUdder(pig.get().getFunctionUdder()));
            } else {
                udder = 4;
            }
            Integer adg = Integer.parseInt(convertAdg(pig.get().getAdg()));
            Optional<Minings> mining = miningsRepository.findByIndexAndOriginWeightAndFootAndGentialAndUdderAndAdg(index,weight,foot,gential,udder,adg);
            if (mining.isPresent()){
                mining.get().setClassification(classification);
                Minings m = miningsRepository.save(mining.get());
                if (m != null){
                    return new ApiResponse(true,"success");
                }
                return null;
            }
        }
        return null;
    }
    public String convertIndex(Float index){
        if (index > 105) {
            return "1";
        } else if (index > 95 && index <= 105) {
            return "2";
        } else if (index > 85 && index <= 95) {
            return "3";
        } else {
            return "4";
        }
    }

    public String convertWeight(Float weight) {
        if (weight > 150) {
            return "1";
        } else if (weight > 110 && weight <= 150) {
            return "2";
        } else if (weight > 90 && weight <= 110) {
            return "3";
        } else {
            return "4";
        }
    }

    public static String convertMaleUdder(Integer mUdder) {
        if (mUdder >= 16) {
            return "1";
        } else if (mUdder == 15) {
            return "2";
        } else if (mUdder == 14) {
            return "3";
        } else {
            return "4";
        }
    }

    public static String convertFemaleUdder(Integer fUdder) {
        if (fUdder >= 16) {
            return "1";
        } else if (fUdder >= 14 && fUdder <= 15) {
            return "2";
        } else if (fUdder >= 12 && fUdder <= 13) {
            return "3";
        } else {
            return "4";
        }
    }

    public String convertGential(Integer gential) {
        if (gential == 4 || gential == 5) {
            return "1";
        } else if (gential == 3) {
            return "2";
        } else if (gential == 2) {
            return "3";
        } else {
            return "4";
        }
    }

    public String convertFoot(Integer foot) {
        if (foot == 4 || foot == 5) {
            return "1";
        } else if (foot == 3) {
            return "2";
        } else if (foot == 2) {
            return "3";
        } else {
            return "4";
        }
    }

    public String convertAdg(Float adg) {
        if (adg > 900) {
            return "1";
        } else if (adg > 800 && adg <= 900) {
            return "2";
        } else if (adg >= 700 && adg <= 800) {
            return "3";
        } else {
            return "4";
        }
    }


}
