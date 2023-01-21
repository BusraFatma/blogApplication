package africa.semicolon.blog.controllers;

import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.dtos.requests.CreatePostRequest;
import africa.semicolon.blog.services.PostService;
import africa.semicolon.blog.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")

    public Post viewPost(@PathVariable String postId){
        return postService.viewPost(postId);
    }

    @GetMapping("/post")

    public List<Post> viewPost(){
        return postService.viewAll();
    }
}
