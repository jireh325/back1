package divdev.sn.todo_list.infrastructure.implementation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.domain.model.UserRight;

public class UserDetailsImpl implements UserDetails {

    private final User user;
    private final List<UserRight> userRights;  // Liste de droits utilisateurs

    public UserDetailsImpl(User user, List<UserRight> userRights) {  // Modifiez le constructeur pour accepter une liste de droits
        this.user = user;
        this.userRights = userRights;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Récupère les droits de l'utilisateur pour chaque projet
        return userRights.stream()
            .map(userRight -> {
                // Vérifie si l'utilisateur est administrateur pour ce projet
                if (userRight.isAdmin()) {
                    // Attribue un rôle "ADMIN_PROJECT_<projectId>"
                    return new SimpleGrantedAuthority("ROLE_ADMIN_PROJECT_" + userRight.getIdProject());
                } else {
                    // Attribue un rôle "USER_PROJECT_<projectId>"
                    return new SimpleGrantedAuthority("ROLE_USER_PROJECT_" + userRight.getIdProject());
                }
            })
            .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPass();  // Retourne le mot de passe de l'utilisateur
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // Utiliser l'email comme nom d'utilisateur
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // À adapter en fonction de votre logique métier
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // À adapter en fonction de votre logique métier
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // À adapter en fonction de votre logique métier
    }

    @Override
    public boolean isEnabled() {
        return true;  // À adapter en fonction de votre logique métier
    }

    public User getUser() {
        return user;
    }
}
