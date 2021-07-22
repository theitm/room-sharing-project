package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.entity.FileEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFileMapper {
    FileEntity fromFileDtoToFileEntity(FileDto dto);
    FileDto toFileDto(FileEntity fileEntity);
}