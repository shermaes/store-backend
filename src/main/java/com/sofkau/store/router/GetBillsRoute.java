package com.sofkau.store.router;

import com.sofkau.store.collection.Bills;
import com.sofkau.store.collection.Product;
import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.usecase.GetBillsUseCase;
import com.sofkau.store.usecase.GetProductsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBillsRoute {
    @Bean
    @RouterOperation(path = "/api/get/bills",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetBillsUseCase.class, method = RequestMethod.GET, beanMethod = "apply",
            operation = @Operation(operationId = "getBills", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = Bills.class)))}
            ))
    public RouterFunction<ServerResponse> allBills(GetBillsUseCase get) {
        return route(GET("/api/get/bills"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), BillsDTO.class))
        );
    }
}
