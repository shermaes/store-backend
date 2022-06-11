package com.sofkau.store.router;

import com.sofkau.store.collection.Receipt;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.usecase.CreateReceiptsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateReceiptsRoute {
    @Bean
    @RouterOperation(path = "/api/create/receipt", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = CreateReceiptsUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createReceipt", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = Receipt.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid receipt details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Receipt.class)))
            ))
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

