package org.example.port;

import org.example.model.domain.BoardStatus;
import java.util.Optional;
import java.util.Set;
import org.example.model.dto.BoardQueryModels.BoardDetail;
import org.example.model.dto.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryPort {

    Optional<BoardDetail> findById(Long id);

    Page<BoardSummary> findAll(Pageable pageable);

    Page<BoardSummary> findByStatusesList(Set<BoardStatus> statuses, Pageable pageable);
}
    