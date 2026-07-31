package com.example.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatController {

    private ChatClient ca;

    public ChatController(ChatClient chatClient)
    {
        this.ca= chatClient;
    }

    @Value("classpath:usermessage.st")
    private Resource resource;

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="query", required = true) String query)
    {
        String res =
                ca.prompt()
                        .system("Give answer as per 10 year software developer")
                        .user(u->u.text(resource).param("techName","Spring"))
                        .call()
                        .content();
        return ResponseEntity.ok(res);
    }
}
