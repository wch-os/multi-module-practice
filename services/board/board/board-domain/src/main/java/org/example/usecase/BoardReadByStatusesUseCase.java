package org.example.usecase;

import org.example.model.domain.BoardStatus;
import java.util.Set;
import org.example.model.dto.BoardQueryModels.BoardSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReadByStatusesUseCase {

    Page<BoardSummary> findByStatuses(Set<BoardStatus> statuses, Pageable pageable);
}

