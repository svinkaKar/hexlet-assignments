package exercise.controller;

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

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "comments")
public class CommentsController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @GetMapping
    @RequestMapping(path = "{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping
    @RequestMapping(path = "{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentRepository.findById(id)
                .map(com -> {
                    com.setBody(comment.getBody());
                    return commentRepository.save(com);
                }).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    @DeleteMapping
    @RequestMapping(path = "{id}")
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
// END
