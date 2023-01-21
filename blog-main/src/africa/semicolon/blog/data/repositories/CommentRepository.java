package africa.semicolon.blog.data.repositories;

import africa.semicolon.blog.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findCommentById(String id);
}
