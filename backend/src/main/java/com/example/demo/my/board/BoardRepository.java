package com.example.demo.my.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT * FROM Board ORDER BY boardId DESC", nativeQuery = true)
    List<Board> findAllDesc();

}
