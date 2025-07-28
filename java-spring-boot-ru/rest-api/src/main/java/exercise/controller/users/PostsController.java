package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN


@RestController
@RequestMapping("/api")
public class PostsController {

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create2(@PathVariable String id, @RequestBody String slug,
                                        @RequestBody String title, @RequestBody String body ) {
        var userPost = new Post(slug, title, body, Integer.valueOf(id));
        posts.add(userPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(userPost);
    }
}
// END
