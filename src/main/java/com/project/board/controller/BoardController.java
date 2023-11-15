package com.project.board.controller;

import com.project.board.dto.BoardRequest;
import com.project.board.dto.BoardResponse;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody BoardRequest request) {
        return new ResponseEntity(boardService.save(request), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<BoardResponse> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/search")
    public List<BoardResponse> searchBoardByTitle(@Nullable @RequestParam("title") String title) {
        return boardService.searchBoardByTitle(title);
    }

    @GetMapping("/paging/ex")
    public List<BoardResponse> boardListPage(@RequestParam("page") int page,
                                             @RequestParam("size") int size) {
        return boardService.boardListPage(page, size);
    }

    @GetMapping("/paging")
    public List<BoardResponse> boardListPageSortCreateTime(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size) {
        return boardService.boardListPageSortCreateTime(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody BoardRequest request) {
        return new ResponseEntity<>(boardService.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.deleteById(id), HttpStatus.OK);
    }
}
