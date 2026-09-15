package com.example.url_shortener.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.url_shortener.components.UrlCodeGenerator;
import com.example.url_shortener.errorhandling.CodeAlreadyUsed;
import com.example.url_shortener.errorhandling.UrlNotFound;
import com.example.url_shortener.repository.UrlRepository;

import jakarta.validation.constraints.NotBlank;

;

@Service
public class UrlService {
    final UrlRepository urlRepository;
    final UrlCodeGenerator urlCodeGenerator;

    public record UrlResponse(
            @NotBlank String url,
            @NotBlank String code) {
    };

    public record UrlRequest(
            @NotBlank String url) {
    };

    public UrlService(UrlRepository urlRepository, UrlCodeGenerator urlCodeGenerator) {
        this.urlCodeGenerator = urlCodeGenerator;
        this.urlRepository = urlRepository;
    }

    public UrlResponse createUrl(UrlRequest req) {
        String newCode = urlCodeGenerator.getCode();

        if (urlRepository.getUrl(newCode).isEmpty()) {
            urlRepository.storeUrl(req.url(), newCode);
            return new UrlResponse(req.url(), newCode);
        } else {
            throw new CodeAlreadyUsed();
        }

    }

    public String findUrl(String code) {
        Optional<String> repoCode = urlRepository.getUrl(code);
        if (repoCode.isEmpty()) {
            throw new UrlNotFound();
        } else
            return repoCode.get();

    }
}
