package com.sofkau.store.router;

import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.usecase.CreateProviderUseCase;
import com.sofkau.store.usecase.CreateReceiptsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateReceiptsRoute {
    @Bean
    public RouterFunction<ServerResponse> createReceipt(CreateReceiptsUseCase createReceiptsUseCase) {
        return route(POST("/api/create/receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(receiptDTO -> createReceiptsUseCase.apply(receiptDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}

