package org.example.firstspring.controller;

import org.example.firstspring.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController //Verleiht die Macht eines Controllers, Klasse kann damit Anfragen entgegennehmen
@RequestMapping("/api/greet") //Wie wird der Kontroller angesprochen?

public class GreetingsController {

    @GetMapping//Lauscht auf GET-Anfrage
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/{greetform}")
    public String sayCostumGreet(@PathVariable String greetform, //Gibt an, dass ein variabler Pfad in der URL steckt
                                 @RequestParam String name, //?{Variablenname}={Wert} -> ?name=max
                                 @RequestParam(required = false, defaultValue = "") String s){
        return greetform + " " + name + s;
    }
    @PostMapping
    public String readData(@RequestBody Student student) {
        return student.name();
    }
}
