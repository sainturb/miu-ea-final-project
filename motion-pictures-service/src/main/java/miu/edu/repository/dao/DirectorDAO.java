package miu.edu.repository.dao;

import java.util.List;

import miu.edu.model.Director;

public interface DirectorDAO {
    List<Director> findDirectorByFirstOrLastName(String name);
}
