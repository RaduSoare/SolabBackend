package com.solab.WebApp.controller;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.Suggestion;
import com.solab.WebApp.service.PostService;
import com.solab.WebApp.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/suggestion")
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping
    public ResponseEntity<Suggestion> add(@RequestBody Suggestion suggestion) {
        Suggestion newSuggestion = suggestionService.addSuggestion(suggestion);
        return new ResponseEntity<>(newSuggestion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        suggestionService.deleteSuggestion(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public List<Suggestion> getAllPosts() {
        return suggestionService.getAllSuggestions();
    }
}
