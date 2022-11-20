package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.UserDTO;
import miu.edu.service.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
