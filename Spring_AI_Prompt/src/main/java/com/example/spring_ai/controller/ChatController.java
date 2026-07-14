package com.example.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
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
        /**
         * Passing prompt message as string
         */
//        String prompt = "What is python";
//
//        var res =
//                ca.prompt(prompt)
//                        .call()
//                        .content();
//        return ResponseEntity.ok(res);


        /**
         * Passing prompt message as String to user prompt
         */

//        String prompt1 = "What is python";
//
//        var res =
//                ca.prompt()
//                        .user(prompt1)
//                        .system("Give answer as per 10 year software developer")
//                        .call()
//                        .content();
//        return ResponseEntity.ok(res);

        /**
         * create prompt object and pass as prompt
         */

        Prompt p = new Prompt("What is javascript ?");

        var res =
                ca.prompt(p)
                        .system("Give answer as per 10 year software developer")
                        .call()
                        .content();
        return ResponseEntity.ok(res);
    }
}
