package com.example.demo.my.board;

import com.example.demo.my.dto.BoardSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getBoardId();
    }
}
