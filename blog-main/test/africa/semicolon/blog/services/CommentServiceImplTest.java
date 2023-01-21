package africa.semicolon.blog.services;

import africa.semicolon.blog.data.models.Comment;
import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {
    CommentService commentService;
    PostService postService;
    @BeforeEach
    void setUp(){
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
    }
    @Test
    void testThatCommentIsSavedInTheCommentDb(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setBody("body");

        postService.createPost(createPostRequest);


        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setComment("My comment");
        createCommentRequest.setCommenterName("Kabir");
        createCommentRequest.setPostId(1);
        commentService.createComment(createCommentRequest);
        assertEquals(1, commentService.getAllComments().size());


    }

}