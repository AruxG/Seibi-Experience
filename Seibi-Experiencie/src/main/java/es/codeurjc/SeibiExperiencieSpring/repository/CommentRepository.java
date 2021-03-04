package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	Comment findById(long id);
	
}
