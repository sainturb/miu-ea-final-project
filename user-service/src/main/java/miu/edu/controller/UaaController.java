package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.service.KeycloakService;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("oauth")
@RequiredArgsConstructor
public class UaaController {

    private final KeycloakService keycloakService;

    @PostMapping("authenticate")
    public AccessTokenResponse authenticate(@RequestBody Map<String, String> body) {
        return keycloakService.getAccessToken(body.get("username"), body.get("password"));
    }
}
