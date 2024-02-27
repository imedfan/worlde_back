package com.example.wordle.service.impl;

import com.example.wordle.model.Word;
import com.example.wordle.repository.WordRepository;
import com.example.wordle.service.WordService;
import org.springframework.stereotype.Component;

@Component
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word saveOrUpdate(Word word){
        return wordRepository.saveAndFlush(word);
    }

    public void delete(long id){
        wordRepository.delete(wordRepository.findById(id).get());
    }

    public Word getWordById(long id){
        return wordRepository.findById(id).get();
    }

}
