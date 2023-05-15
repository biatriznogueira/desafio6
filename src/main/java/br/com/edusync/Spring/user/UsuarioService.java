package br.com.edusync.Spring.user;
import br.com.edusync.Spring.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {



        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private JwtService jwtService;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            return userRepository.findByUserName(userName);
        }
    }

}
