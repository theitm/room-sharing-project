package tma.interns.roomsharing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.repository.DistricsRepository;

import java.util.List;

@Service
public class DistricsService {

    @Autowired
    private DistricsRepository repo;

    public List<DistrictEntity> listAll(){
        return repo.findAll();
    }
    public void save(DistrictEntity districtEntity){
        repo.save(districtEntity);
    }
    public DistrictEntity get(String districs_id){
        return repo.findById(districs_id).get();
    }
}
