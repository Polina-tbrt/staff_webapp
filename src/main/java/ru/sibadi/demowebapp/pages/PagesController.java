package ru.sibadi.demowebapp.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sibadi.demowebapp.domain.Payment;
import ru.sibadi.demowebapp.domain.Person;
import ru.sibadi.demowebapp.repository.PaymentRepository;
import ru.sibadi.demowebapp.repository.PersonRepository;

import java.util.List;
import java.util.Random;

@Controller
public class PagesController {

    private final PersonRepository personRepository;
    private final PaymentRepository paymentRepository;

    public PagesController(PersonRepository personRepository, PaymentRepository paymentRepository) {
        this.personRepository = personRepository;
        this.paymentRepository = paymentRepository;
    }

    // GET http://localhost:8080/
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAllPersons());
        return "index"; // index.html
    }

    // GET http://localhost:8080/person/200
    @GetMapping("/person/{id}")
    public String personPage(
            @PathVariable("id") int id,
            Model model
    ) {
        Person person = personRepository.findPersonById(id);
        model.addAttribute("person", person);
        model.addAttribute("payments", paymentRepository.getPaymentsByPersonId(id));
        return "person"; // person.html
    }

    // GET http://localhost:8080/payment/200/300
    @GetMapping("/payment/{personId}/{paymentId}")
    public String paymentPage(
            @PathVariable("personId") int personId,
            @PathVariable("paymentId") int paymentId,
            Model model
    ) {
        Payment payment = paymentRepository.getPaymentById(paymentId);
        model.addAttribute("payment", payment);
        return "payment";
    }

    @PostMapping("/person/{id}")
    public String personEdit(
            @PathVariable("id") int id,
            @RequestParam("name") String name,
            @RequestParam("salary") int salary
    ) {
        Person person = personRepository.findPersonById(id);
        person.setName(name);
        person.setSalary(salary);
        return "redirect:/person/" + id;
    }
}
