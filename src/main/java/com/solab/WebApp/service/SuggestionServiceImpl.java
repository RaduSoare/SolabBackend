package com.solab.WebApp.service;

import com.solab.WebApp.model.Suggestion;
import com.solab.WebApp.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;

    @Override
    public Suggestion addSuggestion(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    public void deleteSuggestion(int id) {
        suggestionRepository.deleteById(id);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return suggestionRepository.findAll();
    }
}
