package org.example.model.domain;

import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long id;

    private String title;

    private String content;

    private BoardStatus status;

    private Instant createdAt;

    private Instant updatedAt;

    @Builder(
        builderClassName = "updateBoardBuilder",
        builderMethodName = "prepareUpdate",
        buildMethodName = "update"
    )
    public void update(String title, String content) {
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(content, "content cannot be null");

        this.title = title;
        this.content = content;
        this.updatedAt = Instant.now();
    }

    public void softDelete() {
        this.status = BoardStatus.REMOVED;
    }

}
