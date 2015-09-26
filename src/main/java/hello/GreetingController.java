package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));

        GreeterPerson greeterPerson = new GreeterPerson("Fred", 1999);
        greeting.setGreeterPerson(greeterPerson);

        GreetingOccasion go = new GreetingOccasion("Christmas");
        greeting.getGreetingOccasions().add(go);

        go = new GreetingOccasion("Easter");
        greeting.getGreetingOccasions().add(go);

        return greeting;
    }
}
