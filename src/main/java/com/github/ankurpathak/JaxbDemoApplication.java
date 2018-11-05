package com.github.ankurpathak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class JaxbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxbDemoApplication.class, args);
    }


    @GetMapping("/message")
    public Message getMessage(){
        return new Message("Hello World!");
    }


    @GetMapping("/messages")
    public Message.Messages getMessages(String hello){
        return new Message.Messages(List.of(new Message("Good, morning!"), new Message("Good, evening!")));
    }


    @GetMapping("/map")
    public Map<String,String> getMap(){
        return Map.of("name", "Ankur Pathak");
    }
}




