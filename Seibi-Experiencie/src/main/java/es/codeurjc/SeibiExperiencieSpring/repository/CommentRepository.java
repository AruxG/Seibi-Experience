package es.codeurjc.SeibiExperiencieSpring.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.SeibiExperiencieSpring.model.Comment;

@CacheConfig(cacheNames="comments")
public interface CommentRepository extends JpaRepository<Comment,Long>{
	@Cacheable
	Comment findById(long id);
	
	@CacheEvict(allEntries = true)
	@Override
	<S extends Comment> S save(S s);
	
	@Override
	void delete(Comment comment);
}
