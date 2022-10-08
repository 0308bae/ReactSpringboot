package com.example.demo.my.dto;

import com.example.demo.my.board.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveDto {
    private String title;
    private String contents;

    @Builder
    public BoardSaveDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .build();
    }

}
