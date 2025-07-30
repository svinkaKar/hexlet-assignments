package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();

    // BEGIN
    @Value("${users.admins[0]}")
    private String emails1;

    @Value("${users.admins[1]}")
    private String emails2;

    @Value("${users.admins[2]}")
    private String emails3;

    private List<String> emails = new ArrayList<>();

    @GetMapping("/admins")
    public List<String> home() {
        emails.add(emails1);
        emails.add(emails2);
        emails.add(emails3);

        List<String> filteredSorted = users.stream()
                .filter(user -> emails.contains(user.getEmail()))
                .sorted((u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()))
                .map(User::getName)
                .toList();
        
        return filteredSorted;
    }
    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
