package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
	Comment findById(long id);
	
	void delete(Comment comment);
}
