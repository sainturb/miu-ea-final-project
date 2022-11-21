package miu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.model.TvShow;

@Repository
public interface TvShowRepo extends CrudRepository<TvShow, Long> {

}
