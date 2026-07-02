package com.example.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private ChatClient ollamaClient;
    private ChatClient openaiClient;

    public ChatController(OllamaChatModel ocm, OpenAiChatModel opcm)
    {
        this.ollamaClient= ChatClient.builder(ocm).build();
        this.openaiClient= ChatClient.builder(opcm).build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="query", required = true) String query)
    {
        var res = this.openaiClient.prompt(query).call().content();
        return ResponseEntity.ok(res);
    }
}
