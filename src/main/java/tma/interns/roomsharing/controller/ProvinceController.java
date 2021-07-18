package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.ProvinceEntity;
import tma.interns.roomsharing.service.ProvinceService;

import java.util.List;

@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceservice;

    @GetMapping("/province")
    public List<ProvinceEntity> list(){
        return provinceservice.listAll();
    }
}
