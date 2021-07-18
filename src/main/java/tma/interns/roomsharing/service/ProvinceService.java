package tma.interns.roomsharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.entity.ProvinceEntity;
import tma.interns.roomsharing.repository.ProvinceRepository;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository repo;

    public List<ProvinceEntity> listAll(){
        return repo.findAll();
    }
    public void save(ProvinceEntity provinceEntity){
        repo.save(provinceEntity);
    }
    public ProvinceEntity get(String Province_id){
        return repo.findById(Province_id).get();
    }
}
