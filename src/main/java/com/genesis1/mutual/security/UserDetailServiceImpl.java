package com.genesis1.mutual.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.genesis1.mutual.model.entity.User;
import com.genesis1.mutual.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

       @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el username " + username + " no existe"));
        return new UserDetailsImpl(user);
    }
}
