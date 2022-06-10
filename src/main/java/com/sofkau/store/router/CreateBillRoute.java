package com.sofkau.store.router;

import com.sofkau.store.collection.Bills;
import com.sofkau.store.collection.Product;
import com.sofkau.store.dto.BillsDTO;
import com.sofkau.store.dto.ReceiptDTO;
import com.sofkau.store.usecase.CreateBillUseCase;
import com.sofkau.store.usecase.CreateProductUseCase;
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
public class CreateBillRoute {
    @Bean
    @RouterOperation(path = "/api/create/bill", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = CreateBillUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "createBill", responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(schema = @Schema(implementation = Bills.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid bill details supplied")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = Bills.class)))
            ))
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

