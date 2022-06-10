package com.sofkau.store.router;

import com.sofkau.store.collection.Bills;
import com.sofkau.store.collection.Receipt;
import com.sofkau.store.dto.ProviderDTO;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.usecase.GetBillsUseCase;
import com.sofkau.store.usecase.GetProviderUseCase;
import com.sofkau.store.usecase.GetReceiptsUseCase;
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
public class GetReceiptsRoute {
    @Bean
    @RouterOperation(path = "/api/get/receipts",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE},
            beanClass = GetReceiptsUseCase.class, method = RequestMethod.GET, beanMethod = "apply",
            operation = @Operation(operationId = "getReceipts", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = Receipt.class)))}
            ))
    public RouterFunction<ServerResponse> allReceipts(GetReceiptsUseCase get) {
        return route(GET("/api/get/receipts"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), ReceiptDTO.class))
        );
    }
}
