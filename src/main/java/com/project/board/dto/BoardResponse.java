package com.project.board.dto;

import com.project.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponse {

    private Long id;

    private String writer;

    private String title;

    private String content;

    public static BoardResponse toDTO(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
