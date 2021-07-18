package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.WardEntity;

public interface WardRepository extends JpaRepository<WardEntity, String> {
}
