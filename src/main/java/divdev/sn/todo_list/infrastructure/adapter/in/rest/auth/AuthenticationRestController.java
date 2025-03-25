package divdev.sn.todo_list.infrastructure.adapter.in.rest.auth;

import divdev.sn.todo_list.application.dto.LoginDto;
import divdev.sn.todo_list.application.dto.UserDto;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.application.port.in.UseCasePortUser;

import divdev.sn.todo_list.infrastructure.service.AuthenticationService;
import divdev.sn.todo_list.infrastructure.service.JwtService;
import divdev.sn.todo_list.infrastructure.implementation.UserDetailsImpl;
import divdev.sn.todo_list.infrastructure.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UseCasePortUser useCasePortUser;

    public AuthenticationRestController(JwtService jwtService, AuthenticationService authenticationService, UseCasePortUser useCasePortUser) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.useCasePortUser = useCasePortUser;
    }

    // Endpoint pour l'inscription
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        User newUser = authenticationService.signup(userDto);
        return ResponseEntity.status(201).body(newUser);
    }

    // Endpoint pour la connexion
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginDto) {
        try {

            UserDetailsImpl authenticatedUser = authenticationService.authenticate(loginDto);
            String jwtToken = jwtService.generateToken(authenticatedUser);

            User user = useCasePortUser.getByEmail(loginDto.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

            return ResponseEntity.ok(new LoginResponse(jwtToken, jwtService.getExpirationTime(), user));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new LoginResponse("Invalid credentials", 0, null));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LoginResponse("User not found", 0, null));
        }
    }
}
