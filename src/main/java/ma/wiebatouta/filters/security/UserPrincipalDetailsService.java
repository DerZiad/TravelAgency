package ma.wiebatouta.filters.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.wiebatouta.models.User;
import ma.wiebatouta.repositories.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.userRepository.findByUsername(username);
        if(users.size() != 1) {
            	throw new UsernameNotFoundException("User not found");
        }else {
        	User user = users.get(0);
        	return user;
        }
    }
}