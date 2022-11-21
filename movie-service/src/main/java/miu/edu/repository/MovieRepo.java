package miu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.model.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {

}
