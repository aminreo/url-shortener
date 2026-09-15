package com.example.url_shortener.components;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component 
public class UrlCodeGenerator{

    public String getCode(){
        return UUID.randomUUID().toString();
    }

}