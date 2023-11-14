package com.project.board.repository;

import com.project.board.entity.Board;
import com.project.board.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Board> searchBoardTitle(String title) {

        QBoard board = QBoard.board;

        return jpaQueryFactory.select(board)
                .from(board)
                .where(board.title.eq(title))
                .fetch();
    }

    @Override
    public List<Board> boardListPage(long offset, int pageSize) {

        QBoard board = QBoard.board;

        return jpaQueryFactory.selectFrom(board)
                .offset(offset)
                .limit(pageSize)
                .fetch();
    }
}
