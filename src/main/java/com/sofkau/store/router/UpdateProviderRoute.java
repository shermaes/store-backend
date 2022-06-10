package com.sofkau.store.router;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.usecase.UpdateProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProvider(UpdateProviderUseCase updateProviderUseCase){
        return route(PUT("/api/update/provider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(providerDTO -> updateProviderUseCase.apply(providerDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
