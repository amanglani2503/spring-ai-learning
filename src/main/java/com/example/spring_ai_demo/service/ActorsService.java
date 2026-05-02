package com.example.spring_ai_demo.service;

import com.example.spring_ai_demo.util.Constants;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.template.st.StTemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ActorsService {
    @Autowired
    private ChatClient chatClient;

    public String getMoviesByActor(String by) {
        PromptTemplate promptTemplate = PromptTemplate.builder()
                .renderer(StTemplateRenderer.builder().startDelimiterToken('<').endDelimiterToken('>').build())
                .template(Constants.MOVIES_BY_COMPOSER_TEMPLATE)
                .build();

        Prompt prompt = promptTemplate.create(Map.of("composer", by));

        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
