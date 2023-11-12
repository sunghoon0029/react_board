package com.project.board.dto;

import com.project.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponse {

    private Long id;

    private String writer;

    private String title;

    private String content;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public static BoardResponse toDTO(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .createdTime(board.getCreatedTime())
                .updatedTime(board.getUpdatedTime())
                .build();
    }
}
