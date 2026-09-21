package com.example.url_shortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/links")
    public UrlResponse urlRequestMap( @Valid  @RequestBody UrlRequest req){
            return urlService.createUrl(req);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/links/{code}")
    public String getLink( @PathVariable String code) {
        return urlService.findUrl(code);
    }
    
    

}