package org.example.service;

import static org.example.exception.BoardCommandErrorCode.BOARD_NOT_FOUND;
import static org.example.exception.BoardCommandErrorCode.DEFAULT;

import org.example.model.domain.Board;
import org.example.model.domain.BoardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.port.BoardCommandPort;
import org.example.usecase.BoardCreateUseCase;
import org.example.usecase.BoardDeleteUseCase;
import org.example.usecase.BoardUpdateUseCase;

@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase, BoardUpdateUseCase, BoardDeleteUseCase {

    private final BoardCommandPort boardCommandPort;

    public Board createBoard(Board board) {
        return boardCommandPort.create(board);
    }

    public Board updateBoard(Board board) {
        return boardCommandPort.update(board);
    }

    public void deleteBoard(Long id) {
        // softDelete 명을 가진 메서드가 생기면 변경
        // 현재 updateStatus로 REMOVE 상태로 변경
        boardCommandPort.updateStatus(id, BoardStatus.REMOVED);

        // Hard Delete 됬는지 확인 - 제외 할 가능성 있음
        Board board = boardCommandPort.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);

        assert board.getStatus() == BoardStatus.REMOVED : DEFAULT;

    }
}
