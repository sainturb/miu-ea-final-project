package miu.edu.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakService {
    @Value("${keycloak.auth-server-url}")
    String url;
    @Value("${keycloak.realm}")
    String realm;
    @Value("${keycloak.resource}")
    String clientId;
    @Value("${keycloak.credentials.secret}")
    String clientSecret;

    String type = "client_credentials";

    Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .grantType(type)
                .clientId(clientId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .serverUrl(url)
                .realm(realm)
                .build();
    }

    public List<UserRepresentation> getUsers() {
        Keycloak keycloak = getInstance();
        return keycloak.realm(realm).users().list();
    }

    public UserRepresentation getUser(String id) {
        Keycloak keycloak = getInstance();
        return keycloak.realm(realm).users().get(id).toRepresentation();
    }
}
