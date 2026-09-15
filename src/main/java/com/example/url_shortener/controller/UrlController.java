package com.example.url_shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.url_shortener.service.UrlService;
import com.example.url_shortener.service.UrlService.UrlRequest;
import com.example.url_shortener.service.UrlService.UrlResponse;

import jakarta.validation.Valid;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService=urlService;
    }
  

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/links")
    public UrlResponse urlRequestMap( @Valid  @RequestBody UrlRequest req){
            return urlService.createUrl(req);
    }
    

}