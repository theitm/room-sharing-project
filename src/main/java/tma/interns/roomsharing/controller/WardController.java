package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.WardEntity;
import tma.interns.roomsharing.service.WardService;

import java.util.List;

@RestController
public class WardController {
    @Autowired
    private WardService wardservice;

    @GetMapping("/ward")
    public List<WardEntity> lis(){
        return wardservice.listAll();
    }
}
