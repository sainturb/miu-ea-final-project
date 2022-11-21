package miu.edu.service;

import java.util.List;

import miu.edu.model.Actor;

public interface ActorService {
    List<Actor> getAllActors();

    Actor getActorById(long id);

    Actor addActor(Actor Actor);

    boolean removeActor(long id);

    Actor updateActor(long id, Actor Actor);
}
