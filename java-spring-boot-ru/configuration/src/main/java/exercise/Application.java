package exercise;

import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import exercise.model.User;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();

    // BEGIN
    @Value("${users.admins}")
    private List<String> adminsEmails;

    @GetMapping("/admins")
    public List<String> getAdmins() {
        return adminsEmails.stream()
                .map(email -> {
                    int atIndex = email.indexOf('@');
                    if (atIndex > 0) {
                        return email.substring(0, atIndex);
                    } else {
                        return email;
                    }
                })
                .sorted()
                .collect(Collectors.toList());
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
