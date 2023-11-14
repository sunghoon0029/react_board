package com.project.board.repository;

import com.project.board.entity.Board;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> searchBoardTitle(String title);

    List<Board> boardListPage(long offset, int pageSize);
}
