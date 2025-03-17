package org.example.persistence.mapper;

import java.util.Optional;
import org.example.domain.Board;
import org.example.model.BoardQueryModels.BoardDetail;
import org.example.model.BoardQueryModels.BoardSummary;
import org.example.persistence.entity.BoardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardEntityMapper {

    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);

    BoardDetail toBoardDetail(BoardEntity boardEntity);

    BoardSummary toBoardSummary(BoardEntity boardEntity);

    default Optional<Board> toOptionalDomain(BoardEntity boardEntity) {
        return Optional.ofNullable(toDomain(boardEntity));
    }

    default Optional<BoardDetail> toOptionalBoardDetail(BoardEntity boardEntity) {
        return Optional.ofNullable(toBoardDetail(boardEntity));
    }
}
