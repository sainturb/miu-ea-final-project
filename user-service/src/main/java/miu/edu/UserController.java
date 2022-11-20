package miu.edu;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("api")
public class UserController {

    @PreAuthorize("USER")
    public void get11(Principal principal) {}


    @Secured({"OWNER","USER"})
    @RolesAllowed({ "OWNER", "USER" })
    @PreAuthorize("hasRole('OWNER') or hasRole('USER')")
    public void get2(Principal principal) {}
}
