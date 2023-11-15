package com.project.board.repository;

import com.project.board.entity.Board;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> boardListPage(long offset, int pageSize);

    List<Board> boardListPageSortCreateTime(long offset, int pageSize);

    List<Board> searchBoardByTitle(String title);

    void updateHits(Long id);
}
