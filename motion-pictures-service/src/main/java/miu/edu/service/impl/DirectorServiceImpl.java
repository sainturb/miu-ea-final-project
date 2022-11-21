package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Director;
import miu.edu.repository.DirectorRepo;
import miu.edu.repository.dao.DirectorDAO;
import miu.edu.service.DirectorService;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepo DirectorRepo;
    private final DirectorDAO directorDAO;

    @Override
    public List<Director> getAllDirectors() {
        List<Director> Directors = new ArrayList<>();
        DirectorRepo.findAll().forEach(Directors::add);
        return Directors;
    }

    @Override
    public Director getDirectorById(long id) {
        return DirectorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Director> findDirectorByFirstOrLastName(String directorname) {
        return directorDAO.findDirectorByFirstOrLastName(directorname);
    }

    @Override
    public Director addDirector(Director Director) {
        Director savedDirector = DirectorRepo.save(Director);
        return savedDirector;
    }

    @Override
    public boolean removeDirector(long id) {
        try {
            DirectorRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Director updateDirector(long id, Director Director) {
        Director.setId(id);
        Director savedDirector = DirectorRepo.save(Director);
        return savedDirector;
    }

}
