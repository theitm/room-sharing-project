package tma.interns.roomsharing.service.file;

import tma.interns.roomsharing.dto.file.FileDto;

import java.util.UUID;

public interface IFileService {
    FileDto createFile (FileDto file);
    FileDto updateFile (FileDto file, UUID fileId);
    FileDto getById (UUID fileId);
    boolean delete(UUID fileId);
    FileDto getByParentTypeAndParentId(int parentType, UUID parentId);
}
