package com.sofkau.store.router;

import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.usecase.CreateBillUseCase;
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
public class CreateBillRoute {
    @Bean
    public RouterFunction<ServerResponse> createBill(CreateBillUseCase createBillUseCase) {
        return route(POST("/api/create/bill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillsDTO.class)
                        .flatMap(billsDTO -> createBillUseCase.apply(billsDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}

