package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
}
