package data.repositories;

import africa.semicolon.blog.data.models.Post;
import africa.semicolon.blog.data.repositories.PostRepository;
import africa.semicolon.blog.data.repositories.PostRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
    }

    @Test
    public void saveNewPost_CountShouldBeOne_Test(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
    }
    @Test
    public void saveNewPost_findById_shouldReturnSavedPostTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
    }
    @Test
    public void saveNewPost_updatePost_countIsOneTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("Updated body");
        updatedPost.setTitle("Updated title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("Updated body", post.getBody());
        assertEquals("Updated title", post.getTitle());
    }
    @Test
    public void deleteItem_countIsZeroTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        postRepository.delete(1);
        assertEquals(0L, postRepository.count());

    }

    @Test
    public void deleteItems_countIsZeroTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post post2 = new Post();
        post2.setBody("our post body");
        post2.setTitle("our post title");
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());

        postRepository.delete(1);
        assertEquals(1L, postRepository.count());

//        postRepository.delete(2);
//        assertEquals(0L, postRepository.count());

    }

    @Test
    public void findPostByIdTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setBody("our post body");
        post2.setTitle("our post title");
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setBody("our post body");
        post3.setTitle("our post title");
        postRepository.save(post3);

        assertEquals(post, postRepository.findById(1));
        assertEquals(post2, postRepository.findById(2));
        assertEquals(post3, postRepository.findById(3));

    }

    @Test
    public void deleteByPostTest(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        postRepository.delete(post);
        assertEquals(0L, postRepository.count());
    }
}