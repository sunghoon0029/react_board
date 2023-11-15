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

    private String contents;

    private int hits;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public static BoardResponse toDTO(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .contents(board.getContents())
                .hits(board.getHits())
                .createdTime(board.getCreatedTime())
                .updatedTime(board.getUpdatedTime())
                .build();
    }

    public BoardResponse(Long id, String writer, String title, String contents, int hits, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.hits = hits;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
