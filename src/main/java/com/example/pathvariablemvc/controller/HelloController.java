package com.example.pathvariablemvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    //localhost:8080/greet/JohnDoe
    @GetMapping("/greet/{name1}")
    public String greet(@PathVariable("name1") String name) {
        return "Hello !" + name + " . ";
    }

    //localhost:8080/info/country/Myanmar/age/19/hobby/Riding
    @GetMapping({"/info/country/{country}/age/{age}/hobby/{hobby}",
    "/info",
    "info/country/{country}",
    "info/country/{country}/age/{age}"})
    public String info(@PathVariable("country") Optional<String> country,
                       @PathVariable("age")Optional<Integer> age,
                       @PathVariable("hobby")Optional<String> hobby) {
        return "Country :: %s , Age :: %d, Hobby :: %s"
                .formatted(country.orElse("Thai"),
                        age.orElse(20),hobby
                                .orElse("Riding"));
    }
}
