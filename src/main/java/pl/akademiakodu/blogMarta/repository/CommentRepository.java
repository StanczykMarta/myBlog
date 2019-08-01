package pl.akademiakodu.blogMarta.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.blogMarta.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
