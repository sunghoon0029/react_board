package com.project.board.repository;

import com.project.board.entity.Board;
import com.project.board.entity.QBoard;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Board> boardListPage(long offset, int pageSize) {

        QBoard board = QBoard.board;

        return jpaQueryFactory.selectFrom(board)
                .offset(offset)
                .limit(pageSize)
                .fetch();
    }

    @Override
    public List<Board> boardListPageSortCreateTime(long offset, int pageSize) {

        QBoard board = QBoard.board;

        OrderSpecifier<?> orderSpecifier = new OrderSpecifier<>(Order.DESC, board.createdTime);

        return jpaQueryFactory.selectFrom(board)
                .offset(offset)
                .limit(pageSize)
                .orderBy(orderSpecifier)
                .fetch();
    }

    @Override
    public List<Board> searchBoardByTitle(String title) {

        QBoard board = QBoard.board;

        return jpaQueryFactory.selectFrom(board)
                .where(board.title.eq(title))
                .fetch();
    }

    @Transactional
    @Override
    public void updateHits(Long id) {

        QBoard board = QBoard.board;

        jpaQueryFactory.update(board)
                .where(board.id.eq(id))
                .set(board.hits, board.hits.add(1))
                .execute();
    }
}
