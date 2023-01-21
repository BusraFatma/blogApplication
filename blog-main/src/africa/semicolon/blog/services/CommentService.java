package africa.semicolon.blog.services;

import africa.semicolon.blog.data.models.Comment;
import africa.semicolon.blog.dtos.requests.CreateCommentRequest;

import java.util.Collection;
import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequest createCommentRequest);

     List<Comment> getAllComments();

     Comment getCommentById(String id);
}
