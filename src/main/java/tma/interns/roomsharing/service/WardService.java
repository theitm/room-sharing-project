package tma.interns.roomsharing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.entity.WardEntity;
import tma.interns.roomsharing.repository.WardRepository;

import java.util.List;

@Service
public class WardService {

    @Autowired
    private WardRepository repo;

    public List<WardEntity> listAll(){
        return repo.findAll();
    }
    public void save(WardEntity wardEntity){
        repo.save(wardEntity);
    }
    public WardEntity get(String Ward_id){
        return repo.findById(Ward_id).get();
    }
}
