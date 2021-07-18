package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.ProvinceEntity;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, String> {
}
