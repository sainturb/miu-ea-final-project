package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Actor;
import miu.edu.repository.ActorRepo;
import miu.edu.service.ActorService;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepo actorRepo;

    @Override
    public List<Actor> getAllActors() {
        List<Actor> Actors = new ArrayList<>();
        actorRepo.findAll().forEach(Actors::add);
        return Actors;
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepo.findById(id).orElse(null);
    }

    @Override
    public Actor addActor(Actor Actor) {
        Actor savedActor = actorRepo.save(Actor);
        return savedActor;
    }

    @Override
    public boolean removeActor(Long id) {
        try {
            actorRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Actor updateActor(Long id, Actor actor) {
        actor.setId(id);
        Actor savedActor = actorRepo.save(actor);
        return savedActor;
    }

}
