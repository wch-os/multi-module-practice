package org.example.usecase;

import org.example.domain.type.BoardStatus;
import java.util.Set;
import org.example.model.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReadByStatusesUseCase {

    Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable);
}

