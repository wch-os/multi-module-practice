package port;

import domain.Board;
import domain.type.BoardStatus;
import java.util.Optional;

public interface BoardCommandPort {

    Optional<Board> findById(Long id);

    Board create(Board board);

    Board update(Board board);

    void updateStatus(Long id, BoardStatus status);
}
