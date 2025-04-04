package org.example.model.dto;

import org.example.model.domain.BoardStatus;
import java.time.Instant;
import lombok.Builder;

public final class BoardQueryModels {

    private BoardQueryModels() {
    }

    @Builder
    public record BoardDetail(
            Long id,
            String title,
            String content,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }

    @Builder
    public record BoardSummary(
            Long id,
            String title,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }
}
