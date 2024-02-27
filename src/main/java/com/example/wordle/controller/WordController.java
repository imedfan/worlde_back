package com.example.wordle.controller;

import com.example.wordle.dto.WordDTO;
import com.example.wordle.model.Word;
import com.example.wordle.service.impl.WordServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class WordController {
    private final WordServiceImpl wordService;

    public WordController(WordServiceImpl wordService) {
        this.wordService = wordService;
    }

    private static final String BASE_PATH = "word/";
    private static final String CREATE_WORD = BASE_PATH + "add";
    private static final String LIST_WORD = BASE_PATH + "list";
    private static final String DELETE_WORD = BASE_PATH + "delete/{id}";
    private static final String UPDATE_WORD = BASE_PATH + "update/{id}";
    private static final String GET_WORD = BASE_PATH + "{id}";
    private static final String GET_TODAY_WORD = BASE_PATH + "today";


    @GetMapping(value = GET_WORD, produces = MediaType.APPLICATION_JSON_VALUE)
    public WordDTO get(
            @PathVariable Long id
    ){
        Word word = wordService.getWordById(id);
        WordDTO wordDTO = new WordDTO(
                word.getId(),
                word.getCreate_date(),
                word.getUse_date(),
                word.getWord()
        );
        return wordDTO;
    }

    @GetMapping(value = GET_TODAY_WORD, produces = MediaType.APPLICATION_JSON_VALUE)
    public WordDTO getToday(){
        Word word = wordService.getWordById(1);
        WordDTO wordDTO = new WordDTO(
                word.getId(),
                word.getCreate_date(),
                word.getUse_date(),
                word.getWord()
        );
        return wordDTO;
    }


    @PostMapping(value = CREATE_WORD, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(
            @RequestBody Word request
    ){
        return ResponseEntity.ok(wordService.saveOrUpdate(request));
    }

}
