package com.example.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entity.QuestionAnswer;
import com.example.chatbot.service.ChatbotService;

@RestController
@RequestMapping("/rest")
public class ChatRestController {

    @Autowired
    private ChatbotService chatBotService;
    
   
    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
    	return chatBotService.handleInput(message);
    }
    
    
    @PostMapping("/getAllQuestions")
    public List<String> questions() {
        List<String> questions = chatBotService.getAllQuestions();
        return questions;
    }
    
  
    @PostMapping("/qa")
    public QuestionAnswer createQuestionAnswer(@RequestBody QuestionAnswer qa) {
        return chatBotService.createQuestionAnswer(qa);
    }
    
  
    @PutMapping("/qa")
    public QuestionAnswer updateQuestionAnswer(@RequestBody QuestionAnswer request) {
        return chatBotService.updateQuestionAnswer(request.getQuestion(),request.getAnswer());
    }

    
  
    @DeleteMapping("/qa")
    public void deleteQuestionAnswer(@RequestBody String question) {
        chatBotService.deleteQuestionAnswer(question);
    }
    
}
