package com.example.demo.my.dto;

import lombok.Getter;

@Getter
public class HelloDto {
    private final String name;

    public HelloDto(String name){
        this.name = name;
    }
}
