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
import lombok.Setter;

import exercise.model.Post;
import exercise.Data;

// BEGIN


@RestController
@RequestMapping("/api")
public class PostsController {

    @Setter
    private static List<Post> posts = Data.getPosts();

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createUserPost(@PathVariable("id") int userId, @RequestBody Post postDto) {
        Post userPost = new Post(userId, postDto.getSlug(), postDto.getTitle(), postDto.getBody());
        posts.add(userPost);
        return userPost;
    }

    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getUserPosts(@PathVariable("id") int userId) {
        return posts.stream()
                .filter(post -> post.getUserId() == userId)
                .toList();
    }
}
// END
