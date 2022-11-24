package miu.edu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Director;
import miu.edu.service.DirectorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/directors")
public class DirectorContoller {

    private final DirectorService directorService;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    @GetMapping(path = "/filter", params = "name")
    public List<Director> findDirectorByFirstOrLastName(String name) {
        return directorService.findDirectorByFirstOrLastName(name);
    }

    @PostMapping
    public Director getAllDirectors(@RequestBody Director director) {
        return directorService.addDirector(director);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDirectorById(@PathVariable Long id) {
        return directorService.removeDirector(id);
    }

    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director director) {
        return directorService.updateDirector(id, director);
    }

}
