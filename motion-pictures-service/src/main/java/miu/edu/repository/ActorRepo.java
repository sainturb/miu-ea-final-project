package miu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.model.Actor;

@Repository
public interface ActorRepo extends CrudRepository<Actor, Long> {

}
