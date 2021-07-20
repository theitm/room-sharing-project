package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.service.DistrictService;

import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService service;
    @GetMapping("/district")
    public List<DistrictEntity> list(){
        return service.listAll();
    }
}
