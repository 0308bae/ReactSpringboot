package com.example.demo.my;

import com.example.demo.my.board.BoardService;
import com.example.demo.my.dto.BoardDto;
import com.example.demo.my.dto.BoardSaveDto;
import com.example.demo.my.dto.HelloDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final BoardService boardService;

    @GetMapping("/hello")
    public HelloDto hello(@RequestParam String name){
        return new HelloDto(name);
    }

    @PostMapping("/hello/posts")
    public Long save(@RequestBody BoardSaveDto requestDto) {
        return boardService.save(requestDto);
    }
}
