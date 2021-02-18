package es.codeurjc.SeibiExperiencieSpring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findAll();

	
}
