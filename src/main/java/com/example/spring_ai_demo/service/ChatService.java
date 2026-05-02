package com.example.spring_ai_demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    // Spring automatically injects the correct model (Ollama now)
    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getResponse(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}