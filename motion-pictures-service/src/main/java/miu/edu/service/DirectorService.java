package miu.edu.service;

import java.util.List;

import miu.edu.model.Director;

public interface DirectorService {
    List<Director> getAllDirectors();

    Director getDirectorById(long id);

    List<Director> findDirectorByFirstOrLastName(String directorname);

    Director addDirector(Director Director);

    boolean removeDirector(long id);

    Director updateDirector(long id, Director Director);
}
