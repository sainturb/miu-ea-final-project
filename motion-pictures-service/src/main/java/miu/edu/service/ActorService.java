package miu.edu.service;

import java.util.List;

import miu.edu.model.Actor;

public interface ActorService {
    List<Actor> getAllActors();

    Actor getActorById(Long id);

    Actor addActor(Actor Actor);

    boolean removeActor(Long id);

    Actor updateActor(Long id, Actor Actor);
}
