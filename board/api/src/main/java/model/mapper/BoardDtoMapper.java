package model.mapper;

import domain.Board;
import model.BoardQueryModels.BoardDetail;
import model.dto.BoardCommandDto.BoardCreateCommand;
import model.dto.BoardCommandDto.BoardUpdateCommand;
import model.dto.BoardQueryDto.BoardDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    Board toDomain(BoardCreateCommand command);

    Board toDomain(Long id, BoardUpdateCommand command);

    BoardDetailResponse toDtoDetail(BoardDetail board);
}
