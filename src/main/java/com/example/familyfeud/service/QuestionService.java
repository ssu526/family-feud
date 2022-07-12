package com.example.familyfeud.service;

import com.example.familyfeud.model.Question;
import com.example.familyfeud.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question getQuestionById(int id){
        try{
            Question question = questionRepository.findById(id).get();
            return question;
        }catch (Exception e){
            return null;
        }
    }

    public int checkAnswer(int question_id, int[] userInput) {
        String answer = questionRepository.findById(question_id).get().getAnswer();

        int[] answerArray = new int[answer.length()];
        for(int i=0; i< answer.length();i++){
            answerArray[i]=Integer.parseInt(answer.substring(i, i+1));
        }

        int numberOfCorrectAnswer = 0;

        for(int j=0; j<answer.length(); j++){
            if(userInput[j]==answerArray[j]) numberOfCorrectAnswer++;
        }

        return numberOfCorrectAnswer;
    }
}
