package tma.interns.roomsharing.service.file;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.entity.FileEntity;
import tma.interns.roomsharing.mapper.IFileMapper;
import tma.interns.roomsharing.repository.FileRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class FileService implements IFileService {
    private final FileRepository fileRepo;
    private final IFileMapper fileMapper;
    public FileService(FileRepository fileRepo, IFileMapper fileMapper) {
        this.fileRepo = fileRepo;
        this.fileMapper = fileMapper;
    }

    public FileDto createFile (FileDto file){
        FileEntity fileEntity = fileMapper.fromFileDtoToFileEntity(file);
        FileEntity returnFile = fileRepo.save(fileEntity);
        return fileMapper.toFileDto(returnFile);
    }

    public FileDto updateFile (FileDto fileDto, UUID fileId){
        FileEntity fileEntity = fileMapper.fromFileDtoToFileEntity(fileDto);
        fileEntity.setFileId(fileId);
        FileEntity returnFile = fileRepo.save(fileEntity);
        return fileMapper.toFileDto(returnFile);
    }

    public boolean delete(UUID fileId) {
        FileEntity fileEntity = fileRepo.findFirstByFileId(fileId);
        if(fileEntity != null){
           fileRepo.deleteById(fileId);
           return true;
        }
        return false;
    }

    public FileDto getById (UUID fileId){
        FileEntity fileEntity = fileRepo.findFirstByFileId(fileId);
        if(fileEntity != null){
            return fileMapper.toFileDto(fileEntity);
        }
        return  null;
    }

    @Override
    public FileDto getByParentTypeAndParentId(int parentType, UUID parentId) {
        FileEntity fileEntity2 = fileRepo.findByParentTypeAndParentId(parentType,parentId);
        if (fileEntity2 != null){
            return fileMapper.toFileDto(fileEntity2);
        }
        return null;
    }

}
