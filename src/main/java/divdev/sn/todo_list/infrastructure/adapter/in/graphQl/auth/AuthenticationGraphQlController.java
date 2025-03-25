package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.auth;

import divdev.sn.todo_list.application.dto.LoginDto;
import divdev.sn.todo_list.application.dto.UserDto;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.infrastructure.service.AuthenticationService;
import divdev.sn.todo_list.infrastructure.service.JwtService;
import divdev.sn.todo_list.infrastructure.implementation.UserDetailsImpl;
import divdev.sn.todo_list.infrastructure.response.LoginResponse;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import divdev.sn.todo_list.application.port.in.UseCasePortUser;


@Controller
public class AuthenticationGraphQlController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UseCasePortUser useCasePortUser;

    public AuthenticationGraphQlController(JwtService jwtService, AuthenticationService authenticationService, UseCasePortUser useCasePortUser) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.useCasePortUser = useCasePortUser;
    }

    @MutationMapping(name = "signup")
    public User register(@Argument("userInput") UserDto userDto) {
        return authenticationService.signup(userDto);
    }

    @MutationMapping(name = "login")
    public LoginResponse authenticate(@Argument("loginInput") LoginDto loginDto) {
        UserDetailsImpl authenticatedUser = authenticationService.authenticate(loginDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        User user = useCasePortUser.getByEmail(loginDto.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Retourner le token JWT avec son expiration
        return new LoginResponse(jwtToken, jwtService.getExpirationTime(), user);
    }

}
