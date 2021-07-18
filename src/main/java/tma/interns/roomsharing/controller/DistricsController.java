package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.DistrictEntity;
import tma.interns.roomsharing.service.DistricsService;

import java.util.List;

@RestController
public class DistricsController {

    @Autowired
    private DistricsService service;
    @GetMapping("/districs")
    public List<DistrictEntity> list(){
        return service.listAll();
    }
}
