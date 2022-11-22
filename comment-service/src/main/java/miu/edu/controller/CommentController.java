package miu.edu.controller;

import miu.edu.model.Comment;
import miu.edu.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public  List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @GetMapping("/movies/{id}")
    public List<Comment> getCommentsByMoviesId(@PathVariable Long id){
        return commentService.getCommentsByMoviesId(id);
    }

    @GetMapping("/tvshows/{id}")
    public List<Comment> getCommentsByTvshowId(@PathVariable Long id){
        return commentService.getCommentsByTvshowId(id);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @DeleteMapping("/{id}")
    public boolean removeComment(@PathVariable Long id){
        try {
            commentService.removeComment(id);
            return true;
        } catch (Error e){
            //TODO save log
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment){
        return commentService.updateComment(id, comment);
    }
}
