package com.taya.dart.app.service;

import com.taya.dart.app.domain.Message;
import com.taya.dart.app.repo.MessageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;

    public Flux<Message> getAll() {
        return messageRepo.findAll();
    }

    public Mono<Message> addOne(Message message) {
        return messageRepo.save(message);
    }
}
