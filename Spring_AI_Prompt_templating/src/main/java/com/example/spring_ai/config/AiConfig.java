package com.example.spring_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){

        return builder
                .defaultSystem("You are helpful coding assistant")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("openai/gpt-oss-120b")
                        .temperature(0.3)
                        .maxTokens(99999))
                .build();
    }

}
