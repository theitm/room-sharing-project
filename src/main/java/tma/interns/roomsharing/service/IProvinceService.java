package tma.interns.roomsharing.service;

import tma.interns.roomsharing.entity.ProvinceEntity;

import java.util.List;

public interface IProvinceService {

    List<ProvinceEntity> listAll();
    void save(ProvinceEntity provinceEntity);
    ProvinceEntity get(String Province_id);
}
