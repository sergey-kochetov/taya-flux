package com.taya.dart.app.service;

import com.taya.dart.app.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService implements ReactiveUserDetailsService {
    private final UserRepo userRepo;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<UserDetails> cast = userRepo.findByUsername(username)
                .cast(UserDetails.class);
        return cast;
    }
}
