package com.telusko.quizapp.service;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.ACCEPTED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.ACCEPTED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.CONFLICT);
    }
}
