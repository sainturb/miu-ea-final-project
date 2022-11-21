package miu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.model.Director;

@Repository
public interface DirectorRepo extends CrudRepository<Director, Long> {

}
