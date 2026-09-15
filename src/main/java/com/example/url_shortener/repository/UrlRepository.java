package com.example.url_shortener.repository;

import java.util.Optional;

public interface UrlRepository {
    public void storeUrl(String url, String code);
    public Optional<String> getUrl(String code);
    
}
