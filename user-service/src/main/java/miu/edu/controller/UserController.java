package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.UserDTO;
import miu.edu.service.KeycloakService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final KeycloakService keycloakService;

    private final ModelMapper mapper;

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

    @PostConstruct
    public void run() {
        keycloakService.addUser(new UserDTO(null, "user1", "user1 f", "user1 l", "user1@mail.com"));
        keycloakService.addUser(new UserDTO(null, "user2", "user2 f", "user2 l", "user2@mail.com"));
        keycloakService.addUser(new UserDTO(null, "user3", "user3 f", "user3 l", "user3@mail.com"));
    }
}
