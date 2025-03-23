package org.example.model.mapper;

import org.example.model.domain.Board;
import org.example.model.dto.BoardQueryModels.BoardDetail;
import org.example.model.dto.BoardCommandDto.BoardCreateCommand;
import org.example.model.dto.BoardCommandDto.BoardUpdateCommand;
import org.example.model.dto.BoardQueryDto.BoardDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    Board toDomain(BoardCreateCommand command);

    Board toDomain(Long id, BoardUpdateCommand command);

    BoardDetailResponse toDtoDetail(BoardDetail board);
}
