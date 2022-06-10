package com.sofkau.store.router;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.usecase.GetProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> allProviders(GetProviderUseCase get) {
        return route(GET("/api/get/providers"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), ProviderDTO.class))
        );
    }
}
