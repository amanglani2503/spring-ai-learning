package com.example.spring_ai_demo.controller;

import com.example.spring_ai_demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return chatService.getResponse(message);
    }
}