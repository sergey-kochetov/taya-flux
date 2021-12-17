package com.taya.dart.app.handlers;

import com.taya.dart.app.domain.Message;
import com.taya.dart.app.dto.Greeting;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Flux<Message> messageFlux = Flux.just("field1", "field2", "field3", "field4", "field5", "field6")
                .map(msg -> new Message(msg));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(messageFlux, Message.class);
    }

    public Mono<ServerResponse> index(ServerRequest request) {
        String user = request.queryParam("user").orElse("n/a");

        return ServerResponse.ok().render("index", Map.of("user", user));
    }
}