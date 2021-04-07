package ru.sibadi.demowebapp.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.sibadi.demowebapp.repository.PersonRepository;

import java.util.Random;

@Controller
public class PagesController {

    private final Random rnd = new Random();
    private final PersonRepository personRepository;

    public PagesController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // GET http://localhost:8080/
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hello", rnd.nextInt());
        model.addAttribute("persons", personRepository.findAllPersons());
        return "index"; // index.html
    }

    // GET http://localhost:8080/person/200
    @GetMapping("/person/{id}")
    public String personPage(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("person", personRepository.findPersonById(id));
        return "person"; // person.html
    }
}
