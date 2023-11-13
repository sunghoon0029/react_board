package com.project.board.controller;

import com.project.board.dto.BoardRequest;
import com.project.board.dto.BoardResponse;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/paging")
    public Page<BoardResponse> paging(@PageableDefault(page = 1) Pageable pageable) {
        Page<BoardResponse> boardList = boardService.paging(pageable);

        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = ((startPage + blockLimit - 1) < boardList.getTotalPages()) ? startPage + blockLimit - 1 : boardList.getTotalPages();

        return boardList;
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
