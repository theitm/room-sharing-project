package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.FileEntity;

import java.util.UUID;
@Repository
public interface FileRepository extends JpaRepository <FileEntity, UUID> {
    FileEntity findFirstByFileId (UUID fileId);
    void deleteById (UUID fileId);
    FileEntity findByParentTypeAndParentId(int parentType, UUID parentId);

}
