package com.example.wordle.dto;


import java.sql.Timestamp;

public record WordDTO(
    long id,
    Timestamp create_date,
    Timestamp use_date,
    String word
){}
