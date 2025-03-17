package controller;

import domain.type.BoardStatus;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import model.BoardQueryModels.BoardSummary;
import model.dto.BoardQueryDto.BoardDetailResponse;
import model.mapper.BoardDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import usecase.BoardReadByStatusesUseCase;
import usecase.BoardReadUseCase;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardQueryApi {

    private final BoardReadUseCase boardReadUseCase;
    private final BoardReadByStatusesUseCase boardReadByStatusesUseCase;

    private final BoardDtoMapper mapper;

    @GetMapping("/{boardId}")
    public BoardDetailResponse getBoard(@PathVariable("boardId") long boardId) {
        var board = boardReadUseCase.getBoard(boardId);

        return mapper.toDtoDetail(board);
    }

    @GetMapping
    public Page<BoardSummary> getBoardsByStatuses(@RequestParam(defaultValue = "ACTIVE,SUSPENDED") Set<BoardStatus> statuses, Pageable pageable) {
        return boardReadByStatusesUseCase.findByStatuses(statuses, pageable);
    }
}
