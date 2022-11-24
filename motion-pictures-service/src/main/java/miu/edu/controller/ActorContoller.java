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
import miu.edu.model.Actor;
import miu.edu.service.ActorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/actors")
public class ActorContoller {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public Actor getAllActors(@RequestBody Actor Actor) {
        return actorService.addActor(Actor);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteActorById(@PathVariable Long id) {
        return actorService.removeActor(id);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor Actor) {
        return actorService.updateActor(id, Actor);
    }

}
