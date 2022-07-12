package com.example.familyfeud.controller;

import com.example.familyfeud.model.Question;
import com.example.familyfeud.model.UserInput;
import com.example.familyfeud.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public String home(Model model){
        return "redirect:/1";
    }

    @GetMapping("/{id}")
    public String home(@PathVariable int id, Model model, @ModelAttribute("input") UserInput input){
        Question question = questionService.getQuestionById(id);
        model.addAttribute("question", question);
        return "index";
    }

    @PostMapping("/result")
    public String submit(Model model, @ModelAttribute("input") UserInput input){
        int question_id = input.getQuestion_id();
        int first = input.getOption_a();
        int second = input.getOption_b();
        int third = input.getOption_c();
        int fourth = input.getOption_d();
        int fifth = input.getOption_e();

        int[] userInput = new int[] {first, second, third, fourth, fifth};

        int result = questionService.checkAnswer(question_id, userInput);
        model.addAttribute("result", result);
        model.addAttribute("question_id", question_id);

        return "index";
    }
}
