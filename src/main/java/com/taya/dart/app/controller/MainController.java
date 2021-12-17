package com.taya.dart.app.controller;

import com.taya.dart.app.domain.Message;
import com.taya.dart.app.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class MainController {
    private final MessageService messageService;

    @GetMapping
    public Flux<Message> list(
            @RequestParam(required = false, defaultValue = "0") Long start,
            @RequestParam(required = false, defaultValue = "100") Long count
    ) {
        Flux<Message> all = messageService.getAll();
        return all;
    }

    @PostMapping
    public Mono<Message> add(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
