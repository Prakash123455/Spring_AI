package com.example.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
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

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="query", required = true) String query)
    {

        PromptTemplate pt = PromptTemplate.builder().template("what is {techName}?").build();

        String s = pt.render(Map.of("techName","Spring"));

        Prompt p = new Prompt(s);


        String res =
                ca.prompt(p)
                        .system("Give answer as per 10 year software developer")
                        .call()
                        .content();
        return ResponseEntity.ok(res);
    }
}
