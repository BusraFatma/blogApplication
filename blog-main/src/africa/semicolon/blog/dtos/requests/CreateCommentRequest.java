package africa.semicolon.blog.dtos.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateCommentRequest {
    private String postId;
    private String commenterName;
    private String comment;
}
