package com.project.board.dto;

import com.project.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardRequest {

    private Long id;

    private String title;

    private String content;

    public Board toEntity(BoardRequest request) {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
