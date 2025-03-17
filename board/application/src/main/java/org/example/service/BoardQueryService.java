package org.example.service;

import static org.example.exception.BoardQueryErrorCode.BOARD_NOT_FOUND;

import org.example.domain.type.BoardStatus;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.model.BoardQueryModels.BoardDetail;
import org.example.model.BoardQueryModels.BoardSummary;
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
                .orElseThrow(BOARD_NOT_FOUND::exception);
    }

    @Override
    public Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable) {
        return boardQueryPort.findByStatusesList(statuses, pageable);
    }
}
