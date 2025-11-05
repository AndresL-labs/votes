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
        questions.put(1, new Question(1, "¿Cuál es el rango de los puertos reservados?", new String[]{"49152 – 65535", "1024 – 49151", "0 – 1023"}));
        questions.put(2, new Question(2, "¿Cuál es la principal diferencia entre serverless y un servidor en la nube?", new String[]{"En serverless tú administras la máquina y en la nube no", "Ambos son iguales pero serverless usa JavaScript", "En serverless solo subes tu código y pagas por uso; en la nube administras el servidor y pagas por tiempo encendido"}));
        questions.put(3, new Question(3, "¿Cuál de las siguientes NO es una herramienta para hacer peticiones a un servidor?", new String[]{"Postman","curl","TomCat"}));
        questions.put(4, new Question( 4,"¿Qué hace HTTPS en un servidor?", new String[]{"Encripta la comunicación","Cambia la url","Sirve para mejor el diseño visual"}));
        questions.put(5, new Question(5, "¿Cuál de las siguientes NO es un pilar para proteger un servidor desplegado?",new String[]{"Configurar firewall y roles de acceso","antener actualizaciones y usar HTTPS","Usar una interfaz responsiva"}));

        votes.put(1, new int[]{0,0,0});
        votes.put(2, new int[]{0,0,0});
        votes.put(3, new int[]{0,0,0});
        votes.put(4, new int[]{0,0,0});
        votes.put(5, new int[]{0,0,0});

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
