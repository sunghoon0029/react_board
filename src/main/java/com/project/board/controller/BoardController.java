package com.project.board.controller;

import com.project.board.dto.BoardRequest;
import com.project.board.dto.BoardResponse;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
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
