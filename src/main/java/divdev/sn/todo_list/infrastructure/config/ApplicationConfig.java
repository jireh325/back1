package divdev.sn.todo_list.infrastructure.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import divdev.sn.todo_list.application.port.in.UseCasePortUser;
import divdev.sn.todo_list.application.port.in.UseCasePortUserRight;
import divdev.sn.todo_list.domain.model.UserRight;
import divdev.sn.todo_list.infrastructure.implementation.UserDetailsImpl;

@Configuration
public class ApplicationConfig {
    private final UseCasePortUser useCasePortUser;
    private final UseCasePortUserRight useCasePortUserRight;

    public ApplicationConfig(UseCasePortUser useCasePortUser, UseCasePortUserRight useCasePortUserRight) {
        this.useCasePortUser = useCasePortUser;
        this.useCasePortUserRight = useCasePortUserRight;
    }

    @Bean
    UserDetailsService userDetailsService() {
    return email -> useCasePortUser.getByEmail(email)
        .map(user -> {
            //récupéreration la liste des UserRight pour cet utilisateur
            List<UserRight> userRights = useCasePortUserRight.getByIdUser(user.getId());

            //création d'une instance de UserDetailsImpl
            return new UserDetailsImpl(user, userRights); 
        })
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}