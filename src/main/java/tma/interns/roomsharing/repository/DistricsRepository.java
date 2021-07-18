package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.DistrictEntity;

public interface DistricsRepository extends JpaRepository<DistrictEntity, String> {
}
