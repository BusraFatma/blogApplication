package data.repositories;

import africa.semicolon.blog.data.models.Comment;
import africa.semicolon.blog.data.repositories.CommentRepository;
import africa.semicolon.blog.data.repositories.CommentRepositoryImpl;
import africa.semicolon.blog.dtos.requests.CreateCommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryImplTest {
private CommentRepository commentRepository;
    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }
    @Test
    public void testThatCountIncrementsWhenNewCommentIsSaved(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

//        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
//        createCommentRequest.setCommenterName("Kabir");
//        createCommentRequest.setComment("My name is kabir");
//        commentRepository.save(createCommentRequest);
    }

    @Test
    public void  testThatIdOneIsReturnedForTheFirstCommentSaved(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);
        assertEquals(1L, comment.getId());
    }

    @Test
    public void testThatCommentCanBeFoundById(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);

        Comment commentTwo = new Comment();
        commentTwo.setCommenterName("Kabir");
        commentTwo.setComment("My name is Kabir");
        commentRepository.save(commentTwo);

        Comment foundComment = commentRepository.findById(1);
        assertEquals(comment, foundComment);

        Comment foundCommentTwo = commentRepository.findById(2);
        assertEquals(commentTwo, foundCommentTwo);
    }

    @Test
    public void testThatCommentCanBeUpdated(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);

        Comment updatedComment = new Comment();
        updatedComment.setId(1);
        updatedComment.setCommenterName("Kabir updated");
        updatedComment.setComment("My name is Kabir updated");

        commentRepository.save(updatedComment);

        assertEquals("Kabir updated", comment.getCommenterName());
        assertEquals("My name is Kabir updated", comment.getComment());
    }

    @Test
    public void testThatIfTwoCommentsAreSaved_TotalCommentReturnedIsTwo(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);

        Comment commentTwo = new Comment();
        commentTwo.setCommenterName("Kabir");
        commentTwo.setComment("My name is Kabir");
        commentRepository.save(commentTwo);

        assertEquals(2, commentRepository.findAll().size());
    }

    @Test
    public void testThatIfTwoCommentsAreSaved_SizeOfDbIsTwo(){
        Comment comment = new Comment();
        comment.setCommenterName("Kabir");
        comment.setComment("My name is Kabir");
        commentRepository.save(comment);

        Comment commentTwo = new Comment();
        commentTwo.setCommenterName("Kabir");
        commentTwo.setComment("My name is Kabir");
        commentRepository.save(commentTwo);

        assertEquals(2, commentRepository.viewAll().size());
    }
}