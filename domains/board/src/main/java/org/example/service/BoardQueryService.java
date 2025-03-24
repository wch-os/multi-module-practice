package org.example.service;


import org.example.model.domain.BoardStatus;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.exception.BoardQueryErrorCode;
import org.example.model.dto.BoardQueryModels.BoardDetail;
import org.example.model.dto.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.port.BoardQueryPort;
import org.example.usecase.BoardReadByStatusesUseCase;
import org.example.usecase.BoardReadUseCase;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase, BoardReadByStatusesUseCase {

    private final BoardQueryPort boardQueryPort;

    @Override
    public BoardDetail getBoard(Long id) {
        return boardQueryPort.findById(id)
                .orElseThrow(BoardQueryErrorCode.BOARD_NOT_FOUND::exception);
    }

    @Override
    public Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable) {
        return boardQueryPort.findByStatusesList(statuses, pageable);
    }
}
