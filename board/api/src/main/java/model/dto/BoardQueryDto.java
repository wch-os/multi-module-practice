package model.dto;

import lombok.Builder;
import model.BoardQueryModels.BoardDetail;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardDetailResponse(
            BoardDetail board
    ){}
}
