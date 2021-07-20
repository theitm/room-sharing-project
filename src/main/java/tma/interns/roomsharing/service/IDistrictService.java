package tma.interns.roomsharing.service;

import tma.interns.roomsharing.entity.DistrictEntity;

import java.util.List;

public interface IDistrictService {
    List<DistrictEntity> listAll();
    void save(DistrictEntity districtEntity);
    DistrictEntity get(String districs_id);
}
