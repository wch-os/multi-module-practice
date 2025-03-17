package org.example.usecase;

import org.example.model.BoardQueryModels.BoardDetail;

public interface BoardReadUseCase {

    BoardDetail getBoard(Long id);
}