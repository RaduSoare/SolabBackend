package com.solab.WebApp.service;

import com.solab.WebApp.model.Post;
import com.solab.WebApp.model.Suggestion;

import java.util.List;

public interface SuggestionService {
    public Suggestion addSuggestion(Suggestion suggestion);
    public void deleteSuggestion(int id);
    public List<Suggestion> getAllSuggestions();
}
