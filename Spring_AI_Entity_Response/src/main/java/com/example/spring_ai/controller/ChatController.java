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

    public ChatController(ChatClient.Builder builder){
        this.ca= builder.build();
    }

    /**
     * Get response in the required POJO format
     * @param query
     * @return
     */
//    @GetMapping("/chat")
//    public ResponseEntity<Tutorial> chat(@RequestParam(value="query", required = true) String query)
//    {
//
//        Prompt p = new Prompt("List out five top programming language and their definition");
//
//        Tutorial res =
//                ca.prompt(p)
//                        .system("Give answer as per 10 year software developer")
//                        .call()
//                        .entity(Tutorial.class);
//        return ResponseEntity.ok(res);
//    }

    /**
     * Get response in the required List of POJO format
     */

    @GetMapping("/chat")
    public ResponseEntity<List<Tutorial>> chat(@RequestParam(value="query", required = true) String query)
    {

        Prompt p = new Prompt("List out five top programming language and their definition");

        List<Tutorial> res =
                ca.prompt(p)
                        .system("Give answer as per 10 year software developer")
                        .call()
                        .entity(new ParameterizedTypeReference<List<Tutorial>>() {
                        });
        return ResponseEntity.ok(res);
    }
}
