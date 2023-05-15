package br.com.edusync.Spring.auth;
import br.com.edusync.Spring.Repository.UserRepository;
import br.com.edusync.Spring.config.JwtService;
import br.com.edusync.Spring.user.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.management.relation.Role;
@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .nomeCompleto(request.getNomeCompleto())
                .userName(request.getUserName())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.USER)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = repository.findByUserName(request.getUserName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}