package miu.edu.service;

import java.util.List;

import miu.edu.model.Director;

public interface DirectorService {
    List<Director> getAllDirectors();

    Director getDirectorById(Long id);

    List<Director> findDirectorByFirstOrLastName(String directorname);

    Director addDirector(Director director);

    boolean removeDirector(Long id);

    Director updateDirector(Long id, Director director);
}
