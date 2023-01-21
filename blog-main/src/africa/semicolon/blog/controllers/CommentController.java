package africa.semicolon.blog.controllers;

import africa.semicolon.blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.blog.services.CommentService;
import africa.semicolon.blog.services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/comment")
    public String addComment(@RequestBody CreateCommentRequest createCommentRequest){
        commentService.createComment(createCommentRequest);
        return "Comment added";
    }
}
