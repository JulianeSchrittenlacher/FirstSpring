package org.example.firstspring.controller;

import org.example.firstspring.model.Message;
import org.example.firstspring.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //Verleiht die Macht eines Controllers, Klasse kann damit Anfragen entgegennehmen
@RequestMapping("/api/greet") //Wie wird der Kontroller angesprochen?

public class GreetingsController {

    @GetMapping//Lauscht auf GET-Anfrage
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/{greetform}/{name}")
    public String sayCostumGreet(@PathVariable String greetform,
                                 @PathVariable String name,//Gibt an, dass ein variabler Pfad in der URL steckt
                                 @RequestParam(required = false, defaultValue = "") String s){
        return greetform + " " + name + s;
    }
    @PostMapping
    public String readData(@RequestBody Student student) {
        return student.name();
    }

    public List<Message> messages = new ArrayList<>();

    @PostMapping("/messages")
    public String readMessages(@RequestBody Message message) {
        messages.add(message);
        return message.getMessage();
    }


}
