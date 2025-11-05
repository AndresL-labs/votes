package com.example.votes.controller;

import com.example.votes.model.Question;
import com.example.votes.model.VoteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class VoteController {
    private final Map<Integer, int[]> votes = new ConcurrentHashMap<>();
    private final Map<Integer, Question> questions = new ConcurrentHashMap<>();

    public VoteController() {
        questions.put(1, new Question(1, "¿Cuál sirve para exponer una IP pública?", new String[]{"WebSockets", "Ngrok", "Tomcat"}));
        questions.put(2, new Question(2, "¿Qué puerto usa HTTP?", new String[]{"22", "80", "3306"}));

        votes.put(1, new int[]{0,0,0});
        votes.put(2, new int[]{0,0,0});
    }

    @PostMapping("/vote")
    public String vote(@RequestBody VoteRequest request) {
        votes.get(request.getQuestionId())[request.getOption()]++;
        return "ok";
    }

    @GetMapping("/results/{id}")
    public int[] getResults(@PathVariable int id) {
        return votes.get(id);
    }
    @GetMapping("/questions")
    public Collection<Question> getQuestions() {
        return questions.values();
    }
    @GetMapping("/results")
    public Map<Integer, int[]> getAllResults() {
        return votes;
    }

    @GetMapping("/full-results")
    public Collection<Question> getFullResults() {
        return questions.values().stream().map(q -> {
            q.setVotes(votes.get(q.getId()));
            return q;
        }).toList();
    }

}
