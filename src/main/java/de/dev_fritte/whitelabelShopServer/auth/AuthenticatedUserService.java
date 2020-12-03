package de.dev_fritte.whitelabelShopServer.auth;

import de.dev_fritte.whitelabelShopServer.User.AuthenticatedUser;
import de.dev_fritte.whitelabelShopServer.User.User;
import de.dev_fritte.whitelabelShopServer.User.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author schmidt.patrick.14gmail.com
 * 03.12.2020
 **/
@Slf4j
@Service
public class AuthenticatedUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("authenticate user [" + username + "]");

        Optional<User> possibleUser = userRepo.findUserByEmail(username);

        User user = possibleUser.orElseThrow(() -> new UsernameNotFoundException("User [" + username + "] not found!"));

        return new AuthenticatedUser(user);
    }
}
