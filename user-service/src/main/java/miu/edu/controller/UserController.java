package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.FavouriteRequestDTO;
import miu.edu.dto.UserDTO;
import miu.edu.model.Favourite;
import miu.edu.service.FavouriteService;
import miu.edu.service.KeycloakService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final KeycloakService keycloakService;

    private final FavouriteService favouriteService;
    private final ModelMapper mapper;

    @GetMapping("user/api-test")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void userTest() {}

    @GetMapping("owner/api-test")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public void ownerTest() {}

    @GetMapping("users")
    public List<UserDTO> getUsers() {
        return this.keycloakService.getUsers()
                .stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("users/{id}")
    public UserDTO getUserInfo(@PathVariable String id) {
        return mapper.map(this.keycloakService.getUser(id), UserDTO.class);
    }

    @PostMapping("users/favourites")
    public Favourite addFavourite(@RequestBody FavouriteRequestDTO body, Principal principal) {
        return favouriteService.add(body.getId(), body.getType(), body.getName(), principal.getName());
    }

    @GetMapping("users/favourites")
    public List getFavourites(Principal principal) {
        return favouriteService.get(principal.getName());
    }

    @DeleteMapping("users/favourites/{id}")
    public void deleteFavourite(@PathVariable Long id, Principal principal) {
        favouriteService.delete(id, principal.getName());
    }

    @PostConstruct
    public void run() {
        keycloakService.addUser(new UserDTO(null, "user1", "user1 f", "user1 l", "user1@mail.com", "USER"));
        keycloakService.addUser(new UserDTO(null, "user2", "user2 f", "user2 l", "user2@mail.com", "USER"));
        keycloakService.addUser(new UserDTO(null, "user3", "user3 f", "user3 l", "user3@mail.com", "USER"));

        keycloakService.addUser(new UserDTO(null, "owner1", "owner1 f", "owner1 l", "owner1@mail.com", "OWNER"));
        keycloakService.addUser(new UserDTO(null, "owner2", "owner2 f", "owner2 l", "owner2@mail.com", "OWNER"));
        keycloakService.addUser(new UserDTO(null, "owner3", "owner3 f", "owner3 l", "owner3@mail.com", "OWNER"));
    }
}
