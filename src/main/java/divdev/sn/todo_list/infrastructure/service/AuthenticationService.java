package divdev.sn.todo_list.infrastructure.service;

import divdev.sn.todo_list.application.dto.UserDto;
import divdev.sn.todo_list.application.dto.LoginDto;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.domain.model.UserRight;
import divdev.sn.todo_list.infrastructure.implementation.UserDetailsImpl;
import divdev.sn.todo_list.application.port.in.UseCasePortUser;
import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import divdev.sn.todo_list.application.port.in.UseCasePortUserRight;

@Service
public class AuthenticationService {

    private final UseCasePortUser useCasePortUser;
    private final UseCasePortUserRight useCasePortUserRight;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UseCasePortUser useCasePortUser, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UseCasePortUserRight useCasePortUserRight) {
        
        this.authenticationManager = authenticationManager;
        this.useCasePortUserRight = useCasePortUserRight;
        this.useCasePortUser = useCasePortUser;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(UserDto input) {
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPass(passwordEncoder.encode(input.getPass()));
    
        return useCasePortUser.create(user);
    }

    public UserDetailsImpl authenticate(LoginDto input) {
        // Authentifier l'utilisateur
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPass())
        );

        // Récupérer l'utilisateur de la base de données
        User authenticatedUser = useCasePortUser.getByEmail(input.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserRight> userRights = useCasePortUserRight.getByIdUser(authenticatedUser.getId());

        System.out.println(authenticatedUser);


        // Retourner l'implémentation de UserDetails avec l'utilisateur et ses droits
        return new UserDetailsImpl(authenticatedUser, userRights);
    }
}