package com.example.demo.my;

import com.example.demo.my.board.BoardService;
import com.example.demo.my.dto.BoardDto;
import com.example.demo.my.dto.BoardSaveDto;
import com.example.demo.my.dto.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final BoardService boardService;

    @PostMapping("/board/posts")
    public Long save(@RequestBody BoardSaveDto requestDto) {
        return boardService.save(requestDto);
    }

    @DeleteMapping("/board/posts/{id}")
    public Long delete(@PathVariable Long id) {
        boardService.delete(id);
        return id;
    }

    @PutMapping("/board/posts/{id}")
    public Long delete(@PathVariable Long id, @RequestBody BoardUpdateDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @GetMapping("/board/posts/{id}")
    public BoardDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @GetMapping("/board/posts/list")
    public List<BoardDto> findAllDesc() {
        return boardService.findAllDesc();
    }
}
