package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.DistrictEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity, String> {
}
