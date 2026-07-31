package com.example.spring_ai.controller;

import com.example.spring_ai.entity.Tutorial;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private ChatClient ca;

    public ChatController(ChatClient chatClient)
    {
        this.ca= chatClient;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="query", required = true) String query)
    {

        Prompt p = new Prompt("List out five top programming language and their definition");

        String res =
                ca.prompt(p)
                        .system("Give answer as per 10 year software developer")
                        .call()
                        .content();
        return ResponseEntity.ok(res);
    }
}
