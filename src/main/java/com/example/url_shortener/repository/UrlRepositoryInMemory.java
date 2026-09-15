package com.example.url_shortener.repository;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UrlRepositoryInMemory implements UrlRepository {
    
    //key, url pairs
    //threadsafety
    private final HashMap<String,String> repo = new HashMap<>(); 
    
    @Override
    public void storeUrl(String url, String code) {
        repo.put(code, url);
    }

    @Override
    public Optional<String> getUrl(String code) {
        return Optional.ofNullable(repo.get(code));
    }

}
