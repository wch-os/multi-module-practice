package service;

import static exception.BoardQueryErrorCode.BOARD_NOT_FOUND;
import static me.nettee.board.application.exception.BoardQueryErrorCode.BOARD_NOT_FOUND;

import domain.type.BoardStatus;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import model.BoardQueryModels.BoardDetail;
import model.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import port.BoardQueryPort;
import usecase.BoardReadByStatusesUseCase;
import usecase.BoardReadUseCase;

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
