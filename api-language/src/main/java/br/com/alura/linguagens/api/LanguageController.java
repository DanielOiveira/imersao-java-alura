package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    LanguageRepository repository;

    @GetMapping(value = "favorite-language/languages")
    public List<Language> findLanguages(){
        return repository.findAll();
    }

    @PostMapping(value = "favorite-language/languages")
    public Language insertLanguage(@RequestBody Language language){
        return repository.save(language);
    }
}
