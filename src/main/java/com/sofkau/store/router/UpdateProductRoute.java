package com.sofkau.store.router;

import com.sofkau.store.dto.ProductDTO;
import com.sofkau.store.usecase.UpdateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProduct(UpdateProductUseCase updateProductUseCase){
        return route(PUT("/api/update/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(productDTO -> updateProductUseCase.apply(productDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
