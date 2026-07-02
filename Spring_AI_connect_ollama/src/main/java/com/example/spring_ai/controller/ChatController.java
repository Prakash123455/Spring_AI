package com.example.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private ChatClient ca;

    public ChatController(ChatClient.Builder builder){
        this.ca= builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="query", required = true) String query)
    {
        var res = ca.prompt(query).call().content();
        return ResponseEntity.ok(res);
    }
}
