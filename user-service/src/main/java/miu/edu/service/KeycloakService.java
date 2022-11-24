package miu.edu.service;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.UserDTO;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    private final ModelMapper mapper;
    @Value("${keycloak.auth-server-url}")
    String url;
    @Value("${keycloak.realm}")
    String realm;
    @Value("${keycloak.resource}")
    String clientId;
    @Value("${keycloak.credentials.secret}")
    String clientSecret;

    String type = "client_credentials";

    public AccessTokenResponse getAccessToken(String username, String password) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .grantType("password")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .realm(realm)
                .serverUrl(url)
                .build();
        return keycloak.tokenManager().getAccessToken();
    }

    Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .grantType(type)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .serverUrl(url)
                .realm(realm)
                .build();
    }

    Keycloak getAdminInstance() {
        return KeycloakBuilder.builder()
                .grantType(type)
                .clientId("admin-cli")
                .clientSecret("2ff34f83-11d1-4fc4-b20f-d3491f9df3e4")
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

    public void addUser(UserDTO user) {
        UserRepresentation userRepresentation = mapper.map(user, UserRepresentation.class);
        userRepresentation.setEnabled(true);
        userRepresentation.setId(null);
        Keycloak keycloak = getAdminInstance();
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();
        String userId = null;
        try {
            Optional<UserRepresentation> userRepresentationOptional = usersResource.search(user.getUsername(), true).stream().findFirst();
            if (userRepresentationOptional.isPresent()) {
                userId = userRepresentationOptional.get().getId();
            } else {
                Response response = usersResource.create(userRepresentation);
                userId = CreatedResponseUtil.getCreatedId(response);
                CredentialRepresentation passwordCredential = new CredentialRepresentation();
                passwordCredential.setTemporary(false);
                passwordCredential.setType(CredentialRepresentation.PASSWORD);
                passwordCredential.setValue(user.getUsername());

                UserResource userResource = usersResource.get(userId);
                userResource.resetPassword(passwordCredential);
            }
        } catch (Exception e) {
        }
        if (userId != null) {
            UserResource userResource = usersResource.get(userId);
            ClientRepresentation webApp = realmResource.clients().findByClientId("web-app").get(0);
            RoleRepresentation roleToAdd = realmResource.clients().get(webApp.getId()).roles().get(user.getRole().toUpperCase()).toRepresentation();
//            RoleRepresentation roleToAdd = realmResource.roles().get(user.getRole()).toRepresentation();
            userResource.roles().clientLevel(webApp.getId()).add(Collections.singletonList(roleToAdd));
        }
    }
}
