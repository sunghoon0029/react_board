package com.project.board.service;

import com.project.board.dto.BoardRequest;
import com.project.board.dto.BoardResponse;
import com.project.board.entity.Board;
import com.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public boolean save(BoardRequest request) {
        Board board = request.toEntity(request);
        boardRepository.save(board);

        return true;
    }

    public List<BoardResponse> findAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponse> boardResponseList = new ArrayList<>();

        for (Board board: boardList) {
            boardResponseList.add(BoardResponse.toDTO(board));
        }
        return boardResponseList;
    }

    public List<BoardResponse> searchBoardTitle(String title) {

        List<BoardResponse> response;

        if (Objects.isNull(title)) {
            response = boardRepository.findAll().stream()
                .map(m ->
                    BoardResponse.builder()
                            .id(m.getId())
                            .writer(m.getWriter())
                            .title(m.getTitle())
                            .content(m.getContent())
                            .createdTime(m.getCreatedTime())
                            .updatedTime(m.getUpdatedTime())
                            .build())
                    .collect(Collectors.toList());
        } else {
            response = boardRepository.searchBoardTitle(title).stream()
                .map(m ->
                    BoardResponse.builder()
                            .id(m.getId())
                            .writer(m.getWriter())
                            .title(m.getTitle())
                            .content(m.getContent())
                            .createdTime(m.getCreatedTime())
                            .updatedTime(m.getUpdatedTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return response;
    }

    public List<BoardResponse> boardListPage(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        return boardRepository.boardListPage(pageRequest.getOffset(), pageRequest.getPageSize()).stream()
            .map(m ->
                BoardResponse.builder()
                    .id(m.getId())
                    .writer(m.getWriter())
                    .title(m.getTitle())
                    .content(m.getContent())
                    .createdTime(m.getCreatedTime())
                    .updatedTime(m.getUpdatedTime())
                    .build())
            .collect(Collectors.toList());
    }

    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id).get();
        BoardResponse response = BoardResponse.toDTO(board);

        return response;
    }

    public boolean update(Long id, BoardRequest request) {
        Board board = boardRepository.findById(id).get();
        board.updateBoard(request.getTitle(), request.getContent());
        boardRepository.save(board);

        return true;
    }

    public boolean deleteById(Long id) {
        boardRepository.deleteById(id);

        return true;
    }
}
