package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Post getPost(@PathVariable long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping(path = "{id}")
    public Post updatePost(@PathVariable long id, @RequestBody Post post) {
        return postRepository.findById(id)
                .map(post1 -> {
                    post1.setTitle(post.getTitle());
                    post1.setBody(post.getBody());
                    return postRepository.save(post1);
                }).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    @DeleteMapping
    public void deletePost(@PathVariable long id) {
        postRepository.deleteById(id);
        commentRepository.deleteByPostId(id);
    }
}
// END
