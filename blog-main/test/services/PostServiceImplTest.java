package services;

import africa.semicolon.blog.data.models.Comment;
import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;
import africa.semicolon.blog.services.PostService;
import africa.semicolon.blog.services.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceImplTest {
private PostService postService;
private CreatePostRequest createPostRequest;
    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }

    @Test
    public void createPostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());
    }
    @Test
    public void viewPostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());
        Post post = postService.viewPost(1);
        assertEquals("Egusi is my best soup", post.getBody());
        assertEquals("New Post", post.getTitle());
    }
    @Test
    public void addCommentTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        Comment comment = new Comment();
        comment.setComment("comment");
        postService.addComment(1, comment);

        Post savedPost = postService.viewPost(1);
        assertEquals(1, savedPost.getComments().size());
        assertEquals("comment", savedPost.getComments().get(0).getComment());
    }
}