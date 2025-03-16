package port;

import domain.type.BoardStatus;
import java.util.Optional;
import java.util.Set;
import model.BoardQueryModels.BoardDetail;
import model.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryPort {

    Optional<BoardDetail> findById(Long id);

    Page<BoardSummary> findAll(Pageable pageable);

    Page<BoardSummary> findByStatusesList(Set<BoardStatus> statuses, Pageable pageable);
}
    