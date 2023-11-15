package com.project.board.dto;

import com.project.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardRequest {

    private Long id;

    private String writer;

    private String title;

    private String contents;

    public Board toEntity(BoardRequest request) {
        return Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .contents(contents)
                .build();
    }
}
