package com.sofkau.store.router;

import com.sofkau.store.usecase.DeleteProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProviderRoute {
@Bean
    public RouterFunction<ServerResponse> deleteProvider(DeleteProviderUseCase deleteProviderUseCase) {
        return route(DELETE("/api/delete/provider/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProviderUseCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
        );
    }
}
