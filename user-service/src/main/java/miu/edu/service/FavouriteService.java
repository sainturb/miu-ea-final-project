package miu.edu.service;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Favourite;
import miu.edu.repository.FavouriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavouriteService {

    private final FavouriteRepository favouriteRepository;

    public Favourite add(Long id, String type, String name, String userId) {
        Favourite favourite = new Favourite();
        favourite.setFavouriteId(id);
        favourite.setName(name);
        favourite.setType(type);
        favourite.setUserId(userId);
        return favouriteRepository.save(favourite);
    }

    public List<Favourite> get(String userId) {
        return favouriteRepository.findAllByUserId(userId);
    }

    public void delete(Long id, String userId) {
        if (get(userId).stream().map(Favourite::getId).collect(Collectors.toList()).contains(id)) {
            favouriteRepository.deleteById(id);
        }
    }

}
